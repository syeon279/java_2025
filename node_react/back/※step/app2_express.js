const express = require('express');
const app = express();

// 1. 경로 /
app.get('/', (req, res)=> {
  res.send('Hello express');
});

// 2. 경로 /api   화면 /api-Get 출력
app.get('/api', (req, res)=>{
  res.send('/apt-Get');
});

// 3. 경로 /api/one 화면 one
app.get('/api/one',(req, res)=>{
  res.send('one');
});

// 4. 경로 /api/posts
app.get('/api/posts', (req, res)=>{
  res.json([
    {
    id:1, content:'one'
    },
    {
    id:2, content:'two'
    },
    {
    id:3, content:'three'
    },
  ]);
});
// 5. 경로 /api/posts
app.post('/api/posts', (req, res)=>{
  res.json([
    {
    id:1, content:'one'
    },
    {
    id:2, content:'two'
    },
  ]);
});

// 6. 경로 /api/posts
app.delete('/api/posts', (req, res)=>{
  res.json([
    {
    id:1, content:'one'
    },
  ]);
});

app.listen(3065, ()=> {
  console.log('server................');
});