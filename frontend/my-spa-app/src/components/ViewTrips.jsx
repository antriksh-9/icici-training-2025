import { useEffect, useState } from 'react'
import Card from './Card';
import AddTrip from './AddTrip';
function ViewTrips() {

    const [trips, setTrips] = useState([]);

    useEffect(() => {
        console.log("Component mounted");
        loadTrips();
    }, []);

    function loadTrips() {
        console.log("Loading trips...");
        //api call
        fetch('http://localhost:3000/trips')
            .then(response => response.json())
            .then(data => {
                console.log("Trips data:", data);
                setTrips(data);
                // Handle the trips data (e.g., update state, display in UI)
            })
            .catch(error => {
                console.error("Error fetching trips:", error);
            });
    }

    const listTrips = trips.map((trip, i) => {
        return (
            <Card key={i} trip={trip}></Card>
        );
    });

    return (
        <div className='container'>
            <h1>View Trips Component</h1>
            {/* <button onClick={loadTrips} className="btn btn-primary">Load Trips</button> */}
            <div className="container">
                <div className="row">
                    {listTrips}
                </div>
                <div className='row'>
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Title</th>
                                <th scope="col">Description</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {trips.map((trip, index) => (
                                <tr key={trip.id}>
                                    <th scope="row">{index + 1}</th>
                                    <td>{trip.title}</td>
                                    <td>{trip.description}</td>
                                    <td><button> X </button></td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
export default ViewTrips;