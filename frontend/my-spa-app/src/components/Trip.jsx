import { useParams } from "react-router";
import { useEffect, useState } from "react";
import Itinerary from "./Itinerary";
import { Card, Container, Row, Col } from "react-bootstrap";
import { Tab, Tabs } from "react-bootstrap";
import Activity from "./Activity";

const Trip = () => {

    const [trip, setTrip] = useState();

    const params = useParams();
    console.log("Trip ID from params:", params.id);

    useEffect(() => {
        // Fetch trip details using params.id
        console.log("Fetching details for trip ID:", params.id);
        fetch(`http://localhost:9090/trips/${params.id}`)
            .then(response => response.json())
            .then(data => {
                console.log("Trip details:", data);
                setTrip(data);
                // Handle the trip details (e.g., update state, display in UI)
            })
            .catch(error => {
                console.error("Error fetching trip details:", error);
            });
    }, [params.id]);

    const itinerariesList = trip && trip.itineraries.map((itinerary, index) => {
        
        const activitiesList = itinerary.activities.map((activity, idx) => {    
            return <Activity key={idx} activity={activity} />
        });
        
        return (
        <Tab key={index} eventKey={itinerary.title} title={itinerary.title}>
            {/*  <span class="right">{itinerary.date}</span></strong> */}

            <Container>
                <Row>
                    <Col><i>{itinerary.date}</i></Col>
                    <Col><strong>{itinerary.description}</strong></Col> 
                    <hr/>
                </Row>
                <Row>
                    {activitiesList}
                </Row>
            </Container>
            
        </Tab>
        )}
);

    return (
        <div className="container my-3">
            <h2>Trip Details</h2>
            {trip && (

                <Card>
                    <Card.Header>{trip.title}</Card.Header>
                    <Card.Body>
                        <Card.Title>{trip.startDate} to {trip.endDate}</Card.Title>
                        <Card.Text>
                        {trip.description}
                        </Card.Text>

                        {/* {itinerariesList} */}
                         <Tabs
                        defaultActiveKey="profile"
                        id="justify-tab-example"
                        className="mb-3"
                        justify
                        >
                            {itinerariesList}
                        </Tabs>
                    </Card.Body>
                </Card>


                // <div>
                //     <h3>{trip.title}</h3>
                //     <p>{trip.description}</p>
                //     <p>Start Date: {trip.startDate}</p>
                //     <p>End Date: {trip.endDate}</p>
                //     <h4>Itineraries:</h4>
                   
                //         {itinerariesList}
                    
                // </div>
            )}
        </div>
    );
}
export default Trip;