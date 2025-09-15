const express = require('express');
const app = express();

const bodyParser = require('body-parser');
app.use(bodyParser.json());

const trips = [
    { id: 1, title: 'Paris', price: 1000, description: 'A romantic getaway in the city of lights.' },
    { id: 2, title: 'New York', price: 1200, description: 'Experience the hustle and bustle of the Big Apple.' },
    { id: 3, title: 'Tokyo', price: 1500, description: 'Explore the vibrant culture and technology of Japan.' },
]

app.get('/', (req, res) => {
    res.send('Hello World!');
});

app.get('/trips', (req, res) => {
    res.json(trips);
});

app.post('/trips', (req, res) => {
    const newTrip = {
        id: trips.length + 1,
        title: req.body.title,
        price: req.body.price,
        description: req.body.description
    };
    trips.push(newTrip);
    res.status(201).json(newTrip);
});
app.listen(3000, () => {
    console.log('Server is running on http://localhost:3000');
});