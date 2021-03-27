/**
 * Angel Segoviano 
 * 2/7/2021
 * ExplorePage
 * js page for ExplorePage
 */
import Axios from 'axios';
import React from 'react';
import Navbar from './Navbar';
import './style.css';
import {Card, Button, Modal} from 'react-bootstrap';
import FormInput from './FormInput';

class ExplorePage extends React.Component {

    constructor() {
        super ();
        this.state ={
            show:null,
            trailData: [{
                trailName: "",
                city: "",
                state: "",
                trailDistance: "",
                description: "",
            }],
            bookmarkModel: {
                user: "",
                trail: {
                    id: "",
                    trailName: "",
                    city: "",
                    state: "",
                    trailDistance: "",
                    description: "",
                }
            },
                user: "",
                userDistance: "",
                userDescription: "",
                trail: {
                    id: "",
                    trailName: "",
                    city: "",
                    state: "",
                    trailDistance: "",
                    description: "",
                },
                modalEventData: '',
        };        
    }

    handleModal = (eventData) =>  {
        console.log("ID Handle ", eventData.id)
        this.setState({modalEventData:eventData}, ()=> this.setState({show:eventData.id}));
    }

    closeModal() {
        this.setState({show:!this.state.show})
    }

    updateUserDistance = (t) => {
        this.setState({userDistance: t});
        console.log("state of form = ", this.state.userDistance);
    }

    updateUserDescription = (t) => {
        this.setState({userDescription: t});
        console.log("state of form = ", this.state);
    }

    // sets the trailData that was clicked on and user id for creating the bookmark  
    async addBookmark(traildata){
       let userID = this.props.dataFormParent;
       await this.setState({bookmarkModel:{trail:traildata, user:userID}});
        const bookData = this.state.bookmarkModel
        this.bookmarkCreate(bookData);
    }
    // calls the rest service call for creating the bookmark using the information from the method addBookmark()
    async bookmarkCreate(bookData){
        const res = await Axios.post('http://localhost:8080/bookmarkapi/create', bookData)
        console.log(res.data)
    }
    async getTrail(id){
        const res = await Axios.get(`http://localhost:8080/trailapi/findByTrailId/${id}`)
        console.log(res.data)
        this.setState({trail: res.data});
        this.addEvent();
    }
    async addEvent() {
        let userID = this.props.dataFormParent;
        this.setState({user:userID});
        const res = await Axios.post('http://localhost:8080/eventapi/create', this.state)
        console.log(res.data)
        this.closeModal()
    }
    handleFormSubmit = (e) => {
      e.preventDefault();
      console.log("in handle event Model submit", e);
        console.log("in handle event Model submit", e.target.trail.value);
        this.getTrail(e.target.trail.value);
    }
    
    //calls the rest service call for finding all trails from the Spring boot application using the url
    async getTrailData(){
        const res = await Axios.get('http://localhost:8080/trailapi/findAll')
        console.log(res.data)
        this.setState({trailData: res.data})
    }
    componentDidMount(){
        document.title="Explore Page";
        this.getTrailData();
    }
    //Displays Trail Data in cards.
    renderTrailData() {
        return this.state.trailData.map((trail, index) => {
            const{id, trailName, city, state, trailDistance, description} = trail
            return (
               <div className="py-2">
               <Card key={index} border="dark" style={{ width: '18rem' }} className="text-center">
                    <Card.Header>{trailName}</Card.Header>
                        <Card.Body>
                                <Card.Text>Location: {city}, {state}</Card.Text>
                                <Card.Text>Distance: {trailDistance} miles</Card.Text>
                                <Card.Text>Description: {description}</Card.Text>
                                    <Button className="explorebtn1" variant="primary" onClick={() => this.addBookmark(trail)} >Add Bookmark</Button>
                                    &nbsp;
                                    <Button className="explorebtn2" variant="primary" onClick={()=>{this.handleModal(trail)}} >Add Event</Button>
                                    <Modal show={this.state.show === id }>
                                        <form onSubmit={this.handleFormSubmit} className="formInput">
                                        <Modal.Header>{this.state.modalEventData.id}</Modal.Header>
                                            <Modal.Body>
                                                <FormInput id="trail" type="hidden" default={this.state.modalEventData.id} />
                                                <FormInput id="userDistance" title="Distance Traveled:"onChange={this.updateUserDistance} />
                                                <FormInput id="userDescription" title="Description:" onChange={this.updateUserDescription} />
                                            </Modal.Body>
                                        <Modal.Footer>
                                                <Button type="submit" >Add</Button>
                                                <Button onClick={()=>{this.closeModal()}}>Cancel</Button>
                                        </Modal.Footer>
                                        </form>
                                    </Modal>
                        </Card.Body>
                </Card>
            </div>
            )
        })  
    }
    
    render () {
        return  (
            <div>
                <Navbar />
            <div className="pageTitle">
                <h1>Explore Trails Page</h1>
            </div>
            <div className="cardContainer" >
                <div className="trailCards">
                {this.renderTrailData()}
                </div>
            </div>
            </div>
        )
    }

}

export default ExplorePage;