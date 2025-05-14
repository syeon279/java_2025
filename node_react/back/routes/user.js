const express = require('express');
const router = express.Router();
const bcrypt = require('bcrypt');
const passport = require('passport');
const {User, Post} = require('../models');
const { isLoggedin, isNotLoggedin } = require('./middlewares');

// 1. 회원가입
// post : localhost:3065/user
// 설정 : Header Content-Type : application/json
// 설정2 : Body    -[ Raw ] - [Json]
// { "email" : "test@gmail.com", "nickname" : "test", "password" : "test"}
router.post('/', isNotLoggedin, async ( req, res, next )=> {
  try{
    //res.send('......회원가입');

    // 1. 이메일 중복 확인  sql - select : 객체.findOne
    const user = await User.findOne({where : { email : req.body?.email, } });
    // 2. 결과 확인 - 존재하면 이미 사용 중인 아이디입니다.
    if(user) {
      return res.status(403).send('이미 사용 중인 아이디입니다.');
    }
    // 3. 비밀번호 암호화
    const hashPassword = await bcrypt.hash(req.body.password, 12);  // 암호화 강도 10~13
    // 4. 사용자 생성 객채.create
    await User.create({
      email: req.body.email,
      nickname: req.body.nickname,
      password: hashPassword,
    });
    // 5. 응답 - 회원가입 성공 ok  
    res.status(201).send('회원가입 완료!');
  } catch (error) {
    console.error(error);
    next(error);
  }
});


// 2. 로그인 
// localhost:3065/user/login
router.post('/login', isNotLoggedin, async (req, res, next) => {
  //res.send('......로그인');
  passport.authenticate('local', (err, user, info) => {
    // 1. err 오류 처리
    if(err){
      console.errror(err);
      return next(err);
    }
    // 2. 인증정보 있다면 - 세션 401 상태코드 ( 인증필요 )
    if (info) {
      return res.status(401).send(info.reaseon);
    }
    // 3. 사용자 세션에 등록 
    return req.logIn( user, async (loginErr)=> {
        // 3-1. 로그인시 에러 발생
        if(loginErr){
          console.errror(loginErr);
          return next(loginErr);
        }
        // 3-2. 사용자 정보 조회 (sql-join)
        const findUser = await User.findOne({
          where : {id : user.id},     // 아이디를 이용해서 정보 조회
          attributes: { exclude :['password'] }, // password 제외하고 조회
          include: [{ 
            model: Post, 
            attributes : ['id'] 
          }, {
            model: User, as :'Followings', // 사용자가 팔로우한 id
            attributes : ['id'] 
          }, {
            model: User,  as :'Followers', // 사용자를 팔로우한 id
            attributes : ['id'] 
          }],
        });
        return res.status(200).json(findUser);
    } );
  })(req, res, next);     // passport.authenticate()의 반환값을 즉시실행
});


module.exports = router;