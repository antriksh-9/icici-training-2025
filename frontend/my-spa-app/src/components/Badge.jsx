import { useState } from "react";

function Badge(props){
   
    // useState(0);
    const [count, setCount] = useState(0);

     function incrementCount(){
        setCount(count + 1);
    }
    return (
        <button onClick={incrementCount} type="button" className="btn btn-primary">
            {props.caption} <span className="badge text-bg-secondary">{count}</span>
        </button>
    )
}
export default Badge;