const express = require('express');
const router = express.Router();

//  post  /post        경로로 들어오면  글쓰기 출력
router.post('/',(req, res)=>{
  res.send('글쓰기');
});


module.exports = router;