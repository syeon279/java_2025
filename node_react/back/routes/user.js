const express = require('express');
const router = express.Router();
const bcrypt = require('bcrypt');
const passport = require('passport');
const { User, Post } = require('../models');
const { isLoggedIn, isNotLoggedIn } = require('./middlewares');

// 1. 회원가입
// post : localhost:3065/user
// 설정 : Header Content-Type : application/json
// 설정2 : Body    -[ Raw ] - [Json]
// { "email" : "test@gmail.com", "nickname" : "test", "password" : "test"}
router.post('/', isNotLoggedIn, async (req, res, next) => {
  try {
    //res.send('......회원가입');

    // 1. 이메일 중복 확인  sql - select : 객체.findOne
    const user = await User.findOne({ where: { email: req.body?.email, } });
    // 2. 결과 확인 - 존재하면 이미 사용 중인 아이디입니다.
    if (user) {
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
router.post('/login', isNotLoggedIn, async (req, res, next) => {
  //res.send('......로그인');
  passport.authenticate('local', (err, user, info) => {
    // 1. err 오류 처리
    if (err) {
      console.errror(err);
      return next(err);
    }
    // 2. 인증정보 있다면 - 세션 401 상태코드 ( 인증필요 )
    if (info) {
      return res.status(401).send(info.reason);
    }
    // 3. 사용자 세션에 등록 
    return req.logIn(user, async (loginErr) => {
      // 3-1. 로그인시 에러 발생
      if (loginErr) {
        console.errror(loginErr);
        return next(loginErr);
      }
      // 3-2. 사용자 정보 조회 (sql-join)
      const findUser = await User.findOne({
        where: { id: user.id },     // 아이디를 이용해서 정보 조회
        attributes: { exclude: ['password'] }, // password 제외하고 조회
        include: [{
          model: Post,
          attributes: ['id']
        }, {
          model: User, as: 'Followings', // 사용자가 팔로우한 id
          attributes: ['id']
        }, {
          model: User, as: 'Followers', // 사용자를 팔로우한 id
          attributes: ['id']
        }],
      });
      return res.status(200).json(findUser);
    });
  })(req, res, next);     // passport.authenticate()의 반환값을 즉시실행
});

// 3. 로그인한 경우 사용자의 정보 가져오기
// GET : localhost:3065/user
// 설정 : Header Cookie: connect.sid=Cookie 값으로 설정된 값
// 로그인 후에 cookie에 id값 남아있음
/*
3-1. router.get 이용해서 - 사용자 정보 페이지 출력
3-2. 1) 로그인 사용자 확인, 로그인한 유저 정보 반환
*/
router.get('/', async (req, res, next) => {
  //res.send('사용자 정보 조회');
  try {
    // 1) 로그인 사용자 확인
    // 2) 로그인한 유저 정보반환
    if (req.user) {
      const fullUser = await User.findOne({
        // 조건 : id로 검색
        where: { id: req.user.email },
        attributes: { exclude: ['password'] },
        include: [
          {
            model: Post,
            attributes: ['id'],
          }, {
            model: User, as: 'Followings',
            attributes: ['id'],
          }, {
            model: User, as: 'Followers',
            attributes: ['id'],
          }
        ]
        // 비밀번호 빼고 결과 가져오기
        // Post, Followers, Followings 
      });
      res.status(200).json(fullUser);
    } else {
      res.status(200).json(null); // 로그인 안되면 null 반환
    }
  } catch (error) {
    console.error(error);
    next(error);
  }
});

//4. 로그아웃
// POST : localhost:3065/user/logout    로그아웃기능입니다 출력
router.post('/logout', isLoggedIn, (req, res, next) => {  // 사용자가 로그인상태면  로그아웃이 실행되도록

  req.logout(function (err) {
    if (err) { return next(err); }

    req.session.destroy((err) => {   ///  
      if (err) {
        return next(err);
      }
      res.send('ok'); // 로그아웃 성공 응답
    });
  });

});
// 5. 닉네임 변경
// Post : localhost:3065/user/nickname
// 1. 로그인
// 2. Header 쿠키설정
// 3. Body - [raw] - json { "nickname" : "4444"}
router.patch('/nickname', isLoggedIn, async (req, res, next) => {
  //res.send('닉네임 변경');
  try {
    await User.update({
      nickname: req.body.nickname,
    }, {
      where: { id: req.user.id },
    });
    res.status(200).json({ nickname: req.body.nickname });
  } catch (err) {
    console.error(err);
    next(err);
  }
});

/////////////////////////////
// 6. 팔로우
// PATCH : localhost:3065/user/:userId/follow
//          localhost:3065/user/1/follow
// 1. 위의 경로로 router 작성
// 2. 넘겨받은 아이디로 유저인지 select 구문 확인 / User.findOne
// 3. 유저에 추가 user.addFollowers
// 4. 상ㅇ태 표시
router.patch('/:userId/follow', isLoggedIn, async (req, res, next) => {
  try {
    console.log('🔴 서버 userId:', req.params.userId);
    const user = await User.findOne({
      where: { id: req.params.userId }
    });
    if (!user) {
      res.status(403).send('유저를 확인해주세요.');
    } else {
      await user.addFollowers(req.user.id);
      res.status(200).json({
        UserId: parseInt(req.params.userId, 10), // 10진수
      });
    }
  } catch (err) {
    console.error(err);
    next(err);
  }
});

// 7. 팔로잉 찾기 (내가 찾아보는 친구들)
// GET : localhost:3065/user/followings 
// 1. 위의 경로로 router 작성
// 2. 넘겨받은 아이디로 유저 찾기
// 3. 해당 유저의 팔로잉 찾기 user.getFollowings()
router.get('/followings', isLoggedIn, async (req, res, next) => {
  try {
    const user = await User.findOne({
      where: { id: req.user.id }
    });
    if (!user) {
      res.status(403).send('유저를 확인해주세요.');  // 403 금지된. 없는 유저
    } else {
      const followings = await user.getFollowings();
      res.status(200).json(
        followings
      );
    }
  } catch (err) {
    console.error(err);
    next(err);
  }
});

// 8. 팔로우 찾기
// Post : localhost:3065/user/followers
// 1. 위의 경로로 router 작성
// 2. 넘겨받은 아이디로 유저 찾기
// 3. 유저에 추가 user.addFollowers
// 4. 해당 유저의 팔로잉 찾기 user.getFollowings()
router.get('/followers', isLoggedIn, async (req, res, next) => {
  try {
    const user = await User.findOne({
      where: { id: req.user.id }
    });
    if (!user) {
      res.status(403).send('유저를 확인해주세요.');
    } else {
      const followers = await user.getFollowers();
      res.status(200).json(
        followers
      );
    }
  } catch (err) {
    console.error(err);
    next(err);
  }
});

// 9. 언팔로우 
// DELETE : localhost:3065/user/:userId/follow
// 1. 위의 경로로 router 작성
// 2. 언팔로우할 친구 찾기
// 3. 팔로우 삭제 removeFollowers
// 4. 상태 표시
router.delete('/:userId/follow', isLoggedIn, async (req, res, next) => {
  try {
    console.log('🔴 서버 userId:', req.params.userId);
    const user = await User.findOne({
      where: { id: req.params.userId }
    });
    if (!user) {
      res.status(403).send('유저를 확인해주세요.');
    } else {
      await user.removeFollowers(req.user.id);
      res.status(200).json({
        UserId: parseInt(req.params.userId, 10), // 
      });
    }
  } catch (err) {
    console.error(err);
    next(err);
  }
});

// 10. 나를 팔로워한 사람 차단
// Post : localhost:3065/user/:userId/follow
// 1. 위의 경로로 router 작성
// 2. 차단할 친구 찾기
// 3. 팔로우 삭제 - removeFollowers
// 4. 상태 표시
router.delete('/follow/:userId', isLoggedIn, async (req, res, next) => {
  try {
    const user = await User.findOne({
      where: { id: req.params.userId }
    });
    if (!user) {
      res.status(403).send('유저를 확인해주세요.');
    } else {
      await user.removeFollowings(req.user.id);
      res.status(200).json({
        UserId: parseInt(req.params.userId, 10), // 
      });
    }
  } catch (err) {
    console.error(err);
    next(err);
  }
});
///////////////////////////////
module.exports = router;