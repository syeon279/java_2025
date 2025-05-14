const passport = require('passport'); // passport 사용자인증 미들웨어
const local = require('./local');  // id와 passport를 사용하여 인증
const { User } = require('../models'); // users 테이블 - User 객체

module.exports = ( ) => {
  // 1. 세션 저장 (Set) - 로그인한 사용자의 정보를 저장
  passport.serializeUser( ( user, done )=> {
    done( null, user.id ); // 세션에는 사용자 id만 저장됨. { id :1, cookie:'sally' }
  });

  // 2. 세션 조회 (Get) - 세션에 자장된 사용자 id를 기반으로 데이터 베이스에서 사용자 조회
  // select * from users where id =? limit 1;
  passport.deserializeUser( async ( id, done  )=> {  // 비동기 처리
    try{
      const user = await User.findOne({where:{id}}); // find: select  id로 사용자 조회
      done(null, user); // 조회된 정보 session에 저장
    } catch(error){ // 에러출력
      console.error(error);
      done(error);
    }
  });

  //3. id , passport 인증
  local();
};