const Sequelize = require('sequelize');

const env = process.env.NODE_ENV || 'delvelopment';
const config = require('../config/config')[env];
const db = {}; // 객체를 생성해서 객체 저장공간 만들기

const sequelize = new Sequelize( config.database, config.username, config.password, config );
// db, username, password, config 설정정보 이용해서 인스턴스 생성

db.sequelize = sequelize; // 인스턴스
db.Sequelize = Sequelize; // Sequelize 라이브러리 db객체에 저장

module.exports = db; // 다른 파일에서도 db 사용 가능하게