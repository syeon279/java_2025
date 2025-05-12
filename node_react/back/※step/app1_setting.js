const http   = require('http');
const server = http.createServer((req, res) => { 
  console.log( req.url , req.method );
  res.write("<h1>ONE</h1>");
  res.write("<h2>TWO</h2>");
  res.write("<h3>THREE</h3>");
  res.end('Hello node');
}); 

server.listen(  3065 , () => { 
  console.log('서버실행 중.....');
});
