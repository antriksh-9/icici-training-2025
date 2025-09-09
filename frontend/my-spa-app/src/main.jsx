import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import 'bootstrap/dist/css/bootstrap.css'
import { BrowserRouter, Route, Routes } from 'react-router'
import Home from './components/Home.jsx'
import About from './components/About.jsx'
import Header from './components/Header.jsx'
import ViewTrips from './components/ViewTrips.jsx'
import AddTrip from './components/AddTrip.jsx'

createRoot(document.getElementById('root')).render(
   <BrowserRouter>
    <Header/>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="/trips" element={<ViewTrips />} />
      <Route path="/addtrip" element={<AddTrip />} />
    </Routes>
  </BrowserRouter>,
)
