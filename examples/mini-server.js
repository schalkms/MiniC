var express = require('express');
var app = express();


app.get('/', function (req, res) {
  Polyglot.eval('minic', `void main() {
                              int a, b, cs;
                              a = 3;
                              b = 4;
                              printf("Hello World from MiniC!");
                              cs = (a * a) + (b * b);
                              printf("SVP:");
                              printf(cs);
                          }`);
  res.send('Hello World from NodeJS!');
});

app.listen(3001, function () {
  console.log('serving at http://localhost:3001')
});
