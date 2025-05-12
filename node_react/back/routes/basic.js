const express = require('express');
const router = express.Router();

// 2. 경로 /api   화면 /api-Get 출력
router.get('/', (req, res)=>{
  res.send('/apt-Get');
});

// 3. 경로 /api/one 화면 one
router.get('/one',(req, res)=>{
  res.send('one');
});

module.exports = router;