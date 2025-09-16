const express = require('express');
const router = express.Router();
const Itinerary = require('../schemas/Itinerary');
const Activity = require('../schemas/Activity');
const advancedResults = require('../middlewares/advancedResults');

router.get('/itineraries', advancedResults(Itinerary), async (req, res) => {
    // const itineraries = await Itinerary.find();
    // res.json(itineraries);
    res.json(res.advancedResults);
});

// router.get('/itineraries', async (req, res) => {
//     const itineraries = await Itinerary.find();
//     res.json(itineraries);
// });

router.get('/itineraries/:id', async (req, res) => {
    const { id } = req.params;
    const itinerary = await Itinerary.findById(id);
    res.json(itinerary);
});

router.post('/itineraries', async (req, res) => {
    const newItinerary = new Itinerary(req.body);
    await newItinerary.save();
    res.status(201).json(newItinerary);
});
router.delete('/itineraries/:id', async (req, res) => {
    const { id } = req.params;
    await Itinerary.findByIdAndDelete(id);
    res.status(204).send();
});

// add activities to itinerary
router.post('/itineraries/:id/activity', async (req, res) => {
    const { id } = req.params;
    const activity = req.body;
    console.log(activity);
    const newActivity = new Activity(activity);
    await newActivity.save();

    console.log(newActivity);
    
    const itinerary = await Itinerary.findById(id);
    itinerary.activities.push(newActivity._id);
    await itinerary.save();
    res.status(201).json(newActivity);


});

// delete activity from itinerary
router.delete('/itineraries/:itineraryId/activity/:activityId', async (req, res) => {
    const { itineraryId, activityId } = req.params;
    await Activity.findByIdAndDelete(activityId);
    const itinerary = await Itinerary.findById(itineraryId);
    itinerary.activities = itinerary.activities.filter(actId => actId.toString() !== activityId);
    await itinerary.save();
    res.status(204).send();
});

module.exports = router;