import { Link } from "react-router";
import Badge from "./Badge";


function Card(props) {

    function deleteTrip() {
        console.log("Delete trip clicked for:", props.trip.id);
        fetch(`http://localhost:3000/trips/${props.trip.id}`, {
            method: 'DELETE',
        })
            .then(response => {
                console.log("Delete response:", response);
                if (response.ok) {
                    console.log("Trip deleted successfully");
                    // Optionally, you can add code here to update the UI after deletion
                } else {
                    console.error("Failed to delete trip");
                }
            })
    }
    return (
        <div className="card" style={{width: '18rem'}}>
            <img src="https://placehold.co/150X100" className="card-img-top" alt="..." />
            <div className="card-body">
                <h5 className="card-title"><Link to={`/trip/${props.trip.id}`}>{props.trip.title}</Link>  </h5>
                <p className="card-text">{props.trip.description}</p>
                <Badge caption="Views"></Badge>
                <button onClick={deleteTrip} className="btn btn-danger"> X </button>
            </div>
        </div>
    );
}
export default Card;