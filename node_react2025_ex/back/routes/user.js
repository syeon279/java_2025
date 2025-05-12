const express = require('express');
const router = express.Router();

//  post  /user          경로로 들어오면  회원가입출력
router.post('/', (req, res)=>{
  res.send('회원가입');
});

//  post  /user/login  경로로 들어오면  로그인출력
router.post('/login', (req, res)=>{
  res.send('로그인');
});

//  get    /user            사용자정보출력    {id:1 , email:'one@gmail.com'}
router.get('/', (req, res)=>{
  res.json([
    {
      id:1,
      email:'one@gmail.com'
    }
  ]);
});

//  post  /logout         로그아웃출력    
router.post('/logout', (req, res)=>{
  res.send('로그아웃');
});

module.exports = router;