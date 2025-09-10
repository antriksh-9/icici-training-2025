import { useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import { Pencil } from 'react-bootstrap-icons';
const Activity = (props) => {
    const [disabled, setDisabled] = useState(true);
    const [description, setDescription] = useState(props.activity.description);

    function handleDecriptionChange(e) {
        setDescription(e.target.value);
    }

    const updateDescription = (e) => {
        console.log("Updating description to:", description);
        fetch(`http://localhost:9090/activities/${props.activity.id}`, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ description })
        }).then(response => {   
            if (response.ok) {
                console.log("Activity updated successfully");
                setDisabled(true);
            } else {
                console.error("Failed to update activity");
            }
        })
    }

  return (

    <Container>
                <Row>
                    <Col><i>{props.activity.time}</i></Col>
                    <Col><textarea onBlur={updateDescription} onChange={handleDecriptionChange} disabled={disabled} value={description} /></Col> 
                    <Col><Pencil onClick={()=>setDisabled(false)}></Pencil></Col>
                </Row>
            </Container>
    )
};
export default Activity;
