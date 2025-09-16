const mongoose = require('mongoose');

const ItinerarySchema = new mongoose.Schema({
    title: { type: String, required: true },
    description: String,
    date: Date,
    activities:  [{ type: mongoose.Schema.Types.ObjectId, ref: 'Activity' }]
});

const Itinerary = mongoose.model('Itinerary', ItinerarySchema);

module.exports = Itinerary;