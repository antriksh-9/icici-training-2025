import Activity from "./Activity";

const Itinerary = (props) => {

    const activityList = props.itinerary.activities && props.itinerary.activities.map((activity, index) => (
        <Activity key={index} activity={activity} />
    ));

    return (
        <div>
            
            {/* {activityList} */}
        </div>
    );
}

export default Itinerary;