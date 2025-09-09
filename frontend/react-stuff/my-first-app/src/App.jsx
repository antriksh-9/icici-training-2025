import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Message from './Message.jsx';
import Badge from './Badge.jsx';
import Card from './Card.jsx';

function App() {
  const [count, setCount] = useState(0)
  const [courses, setCouses] = useState(['Angular', 'React', 'Vue', 'NodeJS', 'MongoDB', 'ExpressJS']);

  const listCourses = courses.map((course, i) =>  <Card key={i} title={course}></Card> );

  return (
    <>
      {/* <h2>Container Component</h2>
      <Message></Message>
      <Badge caption="Inbox"></Badge>
      <Badge caption="Sent"></Badge>
      <Badge caption="Trash"></Badge> */}
      <div className="container">
        <div className="row">
          {listCourses}
        </div>
      </div>
      
      
    </>
  )
}

export default App
