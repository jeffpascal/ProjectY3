var express = require('express')
  , logger = require('morgan')
  , app = express()
  , template = require('jade').compileFile(__dirname + '/source/templates/homepage.jade')
  //defining the page variable to have index.jade (form file)
  , page = require('jade').compileFile(__dirname + '/source/pages/index.jade')

app.use(logger('dev'))
app.use(express.static(__dirname + '/static'))

//trying to input data from html page
//process_get is specified in the form action:
app.get('/process_get', function(req,res,next){
  response = {
    title:req.query.team //getting the value inputed in the form
  };
  console.log(response);
  res.send(JSON.stringify(response));

})


//added a new page that has a form (saved in index.jade in pages folder)
app.get('/index.html', function (req, res, next){
  var html = page({title : 'First Page'})
  res.send(html)
})

app.get('/', function (req, res, next) {
  try {
    var html = template({ title: 'Home' })
    res.send(html)
  } catch (e) {
    next(e)
  }
})

app.listen(process.env.PORT || 3000, function () {
  console.log('Listening on http://localhost:' + (process.env.PORT || 3000))
})
