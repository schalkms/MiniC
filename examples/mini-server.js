var express = require('express');
var app = express();


app.get('/', function (req, res) {
  Polyglot.eval('minic', `void main() {
                            printf("Hello World from MiniC!");
                          }`);
  res.send('Hello World from NodeJS!');
});

app.listen(3001, function () {
  console.log('serving at http://localhost:3001')
});
