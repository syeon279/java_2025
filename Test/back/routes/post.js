const express = require('express');
const router = express.Router();

const multer = require('multer');
const path = require('path');
const { isLoggedIn } = require('./middlewares');
const fs = require('fs');

const { Post, User, Image } = require('../models');
const { error } = require('console');

try {
    fs.accessSync('uploads');
} catch (err) {
    console.log('uploads 폴더가 없으면 생성합니다.');
    fs.mkdirSync('uploads');
}

const upload = multer({
    storage: multer.diskStorage({
        destination(req, file, done) {
            done(null, 'uploads');
        },
        filename(req, file, done) {
            const ext = path.extname(file.originalname);
            const basename = path.basename(file.originalname, ext);
            done(null, basename + '_' + new Date().getTime() + ext);
        },
    }),
    limits: { fileSize: 10 * 1024 * 1024 }
});

router.post('/', isLoggedIn, upload.none(), async (req, res, next) => {
    try {
        const post = await Post.create({
            content: req.body.content,
            UserId: req.user.id
        });

        if (req.body.image) {
            if (Array.isArray(req.body.image)) {
                const images = await Promise.all(
                    req.body.image.map((image) => Image.create({ src: image }))
                );
                await post.addImages(images);
            } else {
                const image = await Image.create({ src: req.body.image });
                await post.addImages(image);
            }
        }

        const fullPost = await Post.findOne({
            where: { id: post.id },
            include: [
                { model: Image, },
                { model: User, attributes: ['id', 'nickname'] },
            ]
        });
        res.status(201).json(fullPost);

    } catch (error) {
        console.error(error);
        next(error);
    }
});

router.post('/images', isLoggedIn, upload.array('image'), (req, res, next) => {
    res.json(req.files.map((v) => v.filename));
    try {

    } catch (err) {
        console.error(err);
        next(err);
    }
});

router.patch('/:postId', isLoggedIn, async (req, res, next) => {
    try {
        await Post.update({
            content: req.body.content,
        }, { where: { id: req.params.postId, UserId: req.user.id, } });
        const post = await Post.findOne({ where: { id: req.params.postId } });
        res.status(200).json({ PostId: parseInt(req.params.postId, 10), content: req.body.content });
    } catch (error) {
        console.log('🐢 PostRouter 글 수정 : ', error);
        next(error);
    }
});

router.delete('/:postId', isLoggedIn, async (req, res, next) => {
    try {
        await Post.destroy({
            where: {
                id: req.params.postId,
                UserId: req.user.id
            }
        });
        res.status(200).json({
            PostId: parseInt(req.params.postId, 10),
        });
    } catch (error) {
        console.log('🐢 PostRouter 글 삭제 : ', error);
        next(error);
    }
});

router.get('/detail/:postId', isLoggedIn, async (req, res, next) => {
    const fullPost = await Post.findOne({
        where: { id: req.params.postId },
        include: [
            { model: Image, },
            { model: User, attributes: ['id', 'nickname'] },
        ]
    });
    res.status(201).json(fullPost);
});

router.get('/posts', async (req, res, next) => {
    try {
        const where = {};
        if (parseInt(req.query.lastId, 10)) {
            where.id = {
                [Op.lt]: parseInt(req.query.lastId, 10)
            }
        };
        const posts = await Post.findAll({
            where,
            limit: 5,
            order: [
                ['createdAt', 'DESC'],
            ],
            include: [
                { model: User, attributes: ['id', 'nickname'] },
                { model: Image },
            ]
        });
        res.status(200).json(posts);
    } catch (error) {
        console.error(error);
        next(error);
    }
});

module.exports = router;