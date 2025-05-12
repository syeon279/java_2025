const express = require('express');
const router = express.Router();

//   post  /posts        경로로들어오면 페이징 출력
router.post('/',(req, res)=>{
  res.send('페이징');
});

module.exports = router;