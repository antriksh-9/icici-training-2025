import Activity from "./Activity";

const Itinerary = (props) => {

    const activityList = props.itinerary.activities && props.itinerary.activities.map((activity, index) => (
        <Activity key={index} activity={activity} />
    ));

    return (
        <div>
            <h3>{props.itinerary.title}</h3>
            <p>{props.itinerary.description}</p>
            <p>Date: {props.itinerary.date}</p>
            {activityList}
        </div>
    );
}

export default Itinerary;