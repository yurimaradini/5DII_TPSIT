// https://expressjs.com/en/starter/hello-world.html

const express = require('express')
const app = express()
const port = 3001

app.get('/', (req, res) => {
  res.sendFile(__dirname + "/formHTML.html")
});

app.get('/dynamicResponse', (req, res) => {
    res.send('<p>BENVENUTO NELLA TESTA DI ' + req.query['first_name'] + " " + req.query['last_name']+'</p>')
  });

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
});