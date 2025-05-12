const express = require('express');
const app = express();
const userRouter = require('./routes/user'); 
const postRouter = require('./routes/post'); 
const postsRouter = require('./routes/posts'); 

app.use('/user', userRouter);
app.use('/post', postRouter);
app.use('/posts', postsRouter);

app.listen(3065, ()=> {
  console.log('server................>>');
});