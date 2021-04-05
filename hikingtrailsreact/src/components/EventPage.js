import Axios from 'axios';
import React from 'react';
import './style.css';
import {Card, Button, Modal} from 'react-bootstrap';
import FormInput from './FormInput';

class EventPage extends React.Component {
   constructor() {
       super();
       this.state = {
           eventData: [{
               id: "",
               user: "",
               userDistance: "",
               userDescription: "",
               trail: {
                   trailName: "",
                   city: "",
                   state: "",
                   trailDistance: "",
                   description: "",
               }
           }],
           show: false,
           modalEventData: '',
       }
   }

    handleModal = (eventData) =>  {
        this.setState({modalEventData:eventData}, () => this.setState({show:true}));
    }

    closeModal() {
        this.setState({show:!this.state.show})
    }

    handleFormSubmit = (e) => {
        e.preventDefault();
        console.log("in handle editform submit", e.target.trail.value);
        this.getTrail(e.target.trail.value);
    }

    async getTrail(id){
        const res = await Axios.get(`http://localhost:8080/eventapi/findByEventId/${id}`)
        console.log(res.data)
        this.setState({trail: res.data});
       this.editEvent();
    }
    
    editEvent = async () => {
        this.setState({id: this.state.modalEventData.id})
        this.setState({user: this.state.modalEventData.user})
        console.log("in Edit Event", this.state)
        const res = await Axios.post(`http://localhost:8080/eventapi/editEvent`, this.state)
        console.log(res.data)
        this.closeModal()
        this.getEventData()
    }

    //update user distance of event
    updateUserDistance = async(t) => {
        await this.setState({userDistance: t});
        console.log("state of form = ", this.state.userDistance);
    }

    //update description of event
    updateUserDescription = async(t) => {
        await this.setState({userDescription: t});
        console.log("state of form = ", this.state);
    }
   
   // deletes an event
    deleteEvent = async(id) => {
        await Axios.delete('http://localhost:8080/eventapi/delete/' + id); 
        this.getEventData();
    }
    
    //dsiplays the events by created by the user
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
                <Card key={id} border="dark" style={{ width: '18rem' }} className="text-center">                               
                    <Card.Header> {trail.trailName}</Card.Header>
                        <Card.Body>
                            <Card.Text>Location: {trail.city}, {trail.state}</Card.Text>
                                <Card.Text>Distance: {trail.trailDistance} miles</Card.Text>
                                {/* <Card.Text>Description: {trail.description}</Card.Text> */}
                                <Card.Text>My Distance: {userDistance}</Card.Text>
                                <Card.Text>My Description: {userDescription}</Card.Text>
                                <Card.Footer>
                                    {/* <Button className="mr-2" variant="primary" onClick={()=>{this.handleModal(event)}} >Edit</Button> */}
                                    <Button className="mr-2" variant="danger" onClick={this.deleteEvent.bind(this, event.id)} >Remove</Button>
                                <Modal show={this.state.show}>
                                    <form onSubmit={this.handleFormSubmit} className="formInput">
                                    <Modal.Header>{this.state.modalEventData.trailName}{trail.trailName}</Modal.Header>
                                        <Modal.Body>
                                            <FormInput id="trail" type="hidden" default={this.state.modalEventData.id} />
                                            <FormInput id="userDistance" title="Distance Traveled:" placeholder={this.state.modalEventData.userDistance} onChange={this.updateUserDistance} default={this.state.modalEventData.userDistance} />
                                            <FormInput id="userDescription" title="Description:" placeholder={this.state.modalEventData.userDescription} onChange={this.updateUserDescription} default={this.state.modalEventData.userDescription}/>
                                        </Modal.Body>
                                    <Modal.Footer>
                                            <Button type="submit" >Save</Button>
                                            <Button onClick={()=>{this.closeModal()}}>Cancel</Button>
                                    </Modal.Footer>
                                    </form>
                                </Modal>
                                </Card.Footer>
                        </Card.Body>
                </Card>
            )
        })  
    }

    render () {
        return  (
            <div>
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