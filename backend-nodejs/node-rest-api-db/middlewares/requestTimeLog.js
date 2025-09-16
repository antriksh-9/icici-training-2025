const requestTime = function (req, res, next) {
  req.requestTime = Date.now()
  console.log('Request Time: ', req.requestTime)
  next()
}

module.exports = requestTime