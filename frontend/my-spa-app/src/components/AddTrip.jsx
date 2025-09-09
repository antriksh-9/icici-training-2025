import { useState } from 'react'
import { Toast } from 'react-bootstrap';
import Alert from 'react-bootstrap/Alert';
function AddTrip() {

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [message, setMessage] = useState(false);

    function addTrip() {
        // e.preventDefault();
        console.log("Add trip clicked");
        const trip = { title, description };
        console.log("Trip to add:", trip);
        fetch('http://localhost:3000/trips', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(trip)
        }).then(response => {
            if (response.ok) {
                console.log("Trip added successfully"); 
                setTitle("");
                setMessage(true);
                setDescription("");
            } else {
                console.error("Failed to add trip");
            }   
        } )  
    }
    function handleTitleChange(e) {
        // console.log("Title changed:", e.target.value);
        setTitle(e.target.value);
    }
    function handleDescriptionChange(e) {
        // console.log("Title changed:", e.target.value);
        setDescription(e.target.value);
    }
    return (
        <div className="container my-3">
            <h2>Add a Trip</h2>

            {message && <Toast onClose={() => setMessage(false)} className="bg-success" delay={3000} autohide>
      <Toast.Header>
        <img src="holder.js/20x20?text=%20" className="rounded me-2" alt="" />
        <strong className="me-auto">Notification</strong>
        <small>Trips Info</small>
      </Toast.Header>
      <Toast.Body>Trip added successfully!</Toast.Body>
    </Toast>}
            <form>
                <div className="mb-3">
                    <label htmlFor="title" className="form-label">Title</label>
                    <input onChange={handleTitleChange} value={title} type="text" className="form-control" id="title" placeholder="Enter trip title"/>
                </div>
                <div className="mb-3">
                    <label htmlFor="description" className="form-label">Description</label>
                    <textarea onChange={handleDescriptionChange} value={description} className="form-control" id="description" rows="3" placeholder="Enter trip description"></textarea>
                </div>
                <button type="button" onClick={addTrip} className="btn btn-primary">Add Trip</button>
            </form>
        </div>
    );
}   
export default AddTrip;
