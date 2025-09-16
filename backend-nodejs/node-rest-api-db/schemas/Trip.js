const mongoose = require('mongoose');

//schema
const tripSchema = new mongoose.Schema({
  title: {type: String, required: true, unique: true},
  price: Number,
  description: String,
  startDate : {type: Date},
  endDate : Date,
  itineraries: [{ type: mongoose.Schema.Types.ObjectId, ref: 'Itinerary' }]

});

//model
const Trip = mongoose.model('Trip', tripSchema);
module.exports = Trip;