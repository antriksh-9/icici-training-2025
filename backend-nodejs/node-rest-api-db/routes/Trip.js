// express routes
const express = require('express');
const router = express.Router();
const Trip = require('../schemas/Trip');

router.get('/trips', async (req, res) => {
    const trips = await Trip.find();
    res.json(trips);
});

router.get('/trips/:id', async (req, res) => {
    const { id } = req.params;
    const trip = await Trip.findById(id);
    res.json(trip);
});

router.post('/trips', async (req, res) => {
    const newTrip = new Trip(req.body);
    await newTrip.save();
    res.status(201).json(newTrip);
});

router.delete('/trips/:id', async (req, res) => {
    const { id } = req.params;
    await Trip.findByIdAndDelete(id);
    res.status(204).send();
});

router.patch('/trips/:id', async (req, res) => {
    const { id } = req.params;
    const updatedTrip = await Trip.findByIdAndUpdate(id, req.body, { new: true });
    res.json(updatedTrip);
});

module.exports = router;

