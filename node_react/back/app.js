const express = require('express');
const app = express();
const basicRouter = require('./routes/basic'); //## 추가1
const testRouter = require('./routes/test');

// 1. 경로 /
app.get('/', (req, res)=> {
  res.send('Hello express');
});

// 2, 3
app.use('/api', basicRouter ); // ## 추가2

app.use('/test', testRouter);

app.listen(3065, ()=> {
  console.log('server................>>');
});