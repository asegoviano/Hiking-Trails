import Axios from 'axios';
import React from 'react';
import Navbar from './Navbar';
import './style.css';
import {Card, Button} from 'react-bootstrap';
import FormInput from './FormInput';

class EventPage extends React.Component {
   constructor() {
       super();
       this.state = {
           eventData: [{
               userDistance: "",
               userDescription: "",
               trail: {
                   trailName: "",
                   city: "",
                   state: "",
                   trailDistance: "",
                   description: "",
               }
           }]
       }
   }

   async getEventData(){
        const res = await Axios.get(`http://localhost:8080/eventapi/findByUserId/${this.props.dataFormParent}`)
        console.log(res.data)
        this.setState({eventData: res.data})
    }
    componentDidMount(){
        this.getEventData()
    }

    renderEventData() {
        return this.state.eventData.map((event, index) => {
            const {id, trail, userDescription, userDistance} = event
            return ( 
                <Card key={id} border="dark" style={{ width: '18rem' }}>                               
                    <Card.Header> {trail.trailName}</Card.Header>
                        <Card.Body>
                            <Card.Header>Location: {trail.city}, {trail.state}</Card.Header>
                                <Card.Header>Distance: {trail.trailDistance} miles</Card.Header>
                                <Card.Text>Description: {trail.description}</Card.Text>
                                <Card.Text>User Distance: {userDistance}</Card.Text>
                                <Card.Text>User Description: {userDescription}</Card.Text>
                                <Card.Footer>
                                    <Button className="mr-2" onClick variant="primary">Edit</Button>
                                    <Button className="mr-2" onClick variant="danger">Remove</Button>
                                </Card.Footer>
                        </Card.Body>
                </Card>
            )
        })  
    }

    render () {
        return  (
            <div>
                <Navbar />
            <div className="pageTitle">
                <h1>Events Page</h1>
            </div>
            <div className="cardContainer" >
                <div className="trailCards">
                    {this.renderEventData()}
                </div>
            </div>
            </div>
        )
    }    
   
}

export default EventPage;