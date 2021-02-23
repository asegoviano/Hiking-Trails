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
import {Card, Button} from 'react-bootstrap';

class ExplorePage extends React.Component {

    constructor() {
        super ();
        this.state ={
            trailData: [{
                trailName: "",
                city: "",
                state: "",
                trailDistance: "",
                description: "",
            }],
        };
    }

    //calls the rest service call for finding all trails from the Spring boot application using the url
    async getTrailData(){
        const res = await Axios.get('http://localhost:8080/trailapi/findAll')
        console.log(res.data)
        this.setState({trailData: res.data})
    }
    componentDidMount(){
        this.getTrailData()
    }

    //attempted to create a demo of displaying the trail data until a table for the time being
    renderTrailData() {
        return this.state.trailData.map((trail, index) => {
            const{id, trailName, city, state, trailDistance, description} = trail
            return (
                <Card key={id} border="dark" style={{ width: '18rem' }}>
                    <Card.Header> {trailName}</Card.Header>
                    <Card.Body>
                                <Card.Header>Location: {city}, {state}</Card.Header>
                                <Card.Header>Distance: {trailDistance} mi.</Card.Header>
                                <Card.Text>Description: {description}</Card.Text>
                                <Card.Footer>
                                <Button className="mr-2" onClick variant="primary">Bookmarks</Button>
                                <Button className="mr-2" onClick variant="primary">Add Event</Button>
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
                Explore Trails Page
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