const mongoose = require('mongoose');

const ActivitySchema = new mongoose.Schema({
    description: { type: String },
    time: {type: String}
});

const Activity = mongoose.model('Activity', ActivitySchema);

module.exports = Activity;