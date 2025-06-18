const express = require('express');
const router = express.Router();
const bcrypt = require('bcrypt');
const passport = require('passport');
const { User, Post, Image } = require('../models');
const { isLoggedIn, isNotLoggedIn } = require('./middlewares');
const { Op } = require('sequelize');

// 회원가입
router.post('/', isNotLoggedIn, async (req, res, next) => {
    try {
        const user = await User.findOne({ where: { email: req.body?.email } });
        if (user) {
            return res.status(403).send('이미 사용 중인 아이디 입니다.')
        }

        const hashPassword = await bcrypt.hash(req.body.password, 12);

        await User.create({
            email: req.body.email,
            nickname: req.body.nickname,
            password: hashPassword,
        });

        res.status(201).send('회원가입 성공');
    } catch (error) {
        console.error(error);
        next(error);
    }
});

// 로그인
router.post('/login', isNotLoggedIn, async (req, res, next) => {
    passport.authenticate('local', (error, user, info) => {
        if (error) {
            console.error(error);
            return next(error);
        }

        if (info) {
            return res.status(401).send(info.reason);
        }

        return req.logIn(user, async (loginError) => {
            if (loginError) {
                console.error(loginError);
                return next(loginError);
            }

            const findUser = await User.findOne({
                where: { id: user.id },
                attributes: { exclued: ['password'] },
                include: [{
                    model: Post,
                    attributes: ['id']
                }]
            });
            return res.status(200).json(findUser);
        });
    })(req, res, next);
});

router.get('/', async (req, res, next) => {
    try {
        if (req.user) {
            const fullUser = await User.findOne({
                where: { id: req.user.email },
                attributes: { exclude: ['password'] },
                include: [{
                    model: Post,
                    attributes: ['id']
                }]
            });
            res.status(200).json(fullUser);
        } else {
            res.status(200).json(null);
        }
    } catch (error) {
        console.error(error);
        next(error);
    }
});

module.exports = router;