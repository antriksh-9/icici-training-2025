const express = require('express');
const router = express.Router();
const Activity = require('../schemas/Activity');
const advancedResults = require('../middlewares/advancedResults');

router.get('/activities',advancedResults(Activity), async (req, res) => {
    res.status(200).json(res.advancedResults);
});


// router.get('/activities', async (req, res) => {
//     const activities = await Activity.find({});
//     res.json(activities);;
// });

router.patch('/activities/:id', async (req, res) => {
    const { id } = req.params;
    const updatedActivity = await Activity.findByIdAndUpdate(id, req.body, { new: true });
    console.log(updatedActivity);
    
    res.json(updatedActivity);
});

module.exports = router;