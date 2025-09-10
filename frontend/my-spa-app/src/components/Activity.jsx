import { useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import { Pencil } from 'react-bootstrap-icons';
const Activity = (props) => {
    const [disabled, setDisabled] = useState(true);
  return (

    <Container>
                <Row>
                    <Col><i>{props.activity.time}</i></Col>
                    <Col><textarea disabled={disabled} value={props.activity.description} /></Col> 
                    <Col><Pencil onClick={()=>setDisabled(false)}></Pencil></Col>
                </Row>
            </Container>
    )
};
export default Activity;
