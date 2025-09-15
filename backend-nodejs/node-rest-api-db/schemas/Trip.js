const mongoose = require('mongoose');

//schema
const tripSchema = new mongoose.Schema({
  title: String,
  price: Number,
  description: String
});

//model
const Trip = mongoose.model('Trip', tripSchema);
module.exports = Trip;