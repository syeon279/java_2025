// 1. require
const express = require('express');
const cors = require('cors');
const session = require('express-session');
const cookieParser = require('cookie-parser');

const passportConfig = require('./passport');
const passport = require('passport');
const path = require('path');

const dotenv = require('dotenv');
const morgan = require('morgan');

const userRouter = require('./routes/user');
const postRouter = require('./routes/post');

dotenv.config();
const app = express();


const db = require('./models');
db.sequelize
    .sync()
    .then(() => {
        console.log('>> 🐾 DB Start >>')
    })
    .catch(console.error);
passportConfig();

app.use(morgan('dev'));
app.use('/', express.static(path.join(__dirname, 'uploads')));
app.use(cors({
    origin: 'http://localhost:3000',
    credentials: true,
}));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cookieParser(process.env.COOKIE_SECRET));
app.use(session({
    saveUninitialized: false,
    resave: false,
    secret: process.env.COOKIE_SECRET,
    cookie: { secure: false }
}));
app.use(passport.initialize());
app.use(passport.session());

app.use('/user', userRouter);
app.use('/post', postRouter);

// 6. 서버 설정 및 실행
app.listen(3065, () => { console.log(' >> server.... >>'); });

