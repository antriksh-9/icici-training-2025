const Activity = (props) => {
    return (
        <div>
            <p>{props.activity.time}</p>
            <textarea rows="3" cols="50" readOnly value={props.activity.description}></textarea>
            
        </div>
    );
}
export default Activity;