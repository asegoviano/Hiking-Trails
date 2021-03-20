import Axios from 'axios';
import React from 'react';
import Navbar from './Navbar';
import './style.css';
import {Card, Button} from 'react-bootstrap';

class BookmarkPage extends React.Component {

    constructor() {
        super();
        this.state = {
            bookmarkData: [{
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
 
    deleteBookmark = (id) => {
        Axios.delete('http://localhost:8080/bookmarkapi/delete/' + id)
        
    }

    //calls the rest service call for finding all bookmarks from the Spring boot application using the url
    async getBookmarkData(){
        const res = await Axios.get(`http://localhost:8080/bookmarkapi/findByUserId/${this.props.dataFormParent}`)
        console.log(res.data)
        this.setState({bookmarkData: res.data})
    }
    
    componentDidMount(){
        this.getBookmarkData()
    }

    renderBookmarkData() {
        return this.state.bookmarkData.map((bookmark, index) => {
            const {id, trail} = bookmark
            return ( 
                <Card key={id} border="dark" style={{ width: '18rem' }}>                               
                    <Card.Header> {trail.trailName}</Card.Header>
                        <Card.Body>
                            <Card.Header>Location: {trail.city}, {trail.state}</Card.Header>
                                <Card.Header>Distance: {trail.trailDistance} miles</Card.Header>
                                <Card.Text>Description: {trail.description}</Card.Text>
                                <Card.Footer>
                                    <Button className="bookmarkbtn" onClick variant="danger" onClick={this.deleteBookmark.bind(this, trail.id)} >Remove</Button>
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
                <h1>Bookmark Trails Page</h1>
            </div>
            <div className="cardContainer" >
                <div className="trailCards">
                    {this.renderBookmarkData()}
                </div>
            </div>
            </div>
        )
    }    
}
 
 export default BookmarkPage;