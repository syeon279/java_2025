const express = require('express');
const router = express.Router();

router.get('/', (req, res)=>{
  res.send('test 완료');
});

module.exports = router;