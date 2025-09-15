const express = require('express');
const app = express();
const router = express.Router()
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const Trip = require('./schemas/Trip');

async function connectToDb() {
  await mongoose.connect('mongodb://127.0.0.1:27017/icici_db');
    console.log('Connected to MongoDB');
}
connectToDb();

app.use(bodyParser.json());

app.use('/api', require('./routes/Trip'));

app.get('/', (req, res) => {
    res.send('Hello World Change!');
})


app.listen(3000, () => {
    console.log('Server is running on port 3000');
});