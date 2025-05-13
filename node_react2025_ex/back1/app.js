const express = require('express');
const app = express();

const test = require('./routes/test');

app.get('/', (req, res)=>{
  res.send('Hello');
});

app.use('/test', test);

app.listen(3065, ()=> {
  console.log('server......>>');
});