import Axios from 'axios';
import React from 'react';
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
 
    deleteBookmark = async(id) => {
        await Axios.delete('http://localhost:8080/bookmarkapi/delete/' + id);  
        this.getBookmarkData();
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
                <Card key={id} border="dark" style={{ width: '18rem' }} className="text-center">                               
                    <Card.Header> {trail.trailName}</Card.Header>
                        <Card.Body>
                            <Card.Text>Location: {trail.city}, {trail.state}</Card.Text>
                                <Card.Text>Distance: {trail.trailDistance} miles</Card.Text>
                                <Card.Text>Description: {trail.description}</Card.Text>
                                <Card.Footer>
                                    <Button className="bookmarkbtn" variant="danger" onClick={this.deleteBookmark.bind(this, bookmark.id)} >Remove</Button>
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
                    {this.renderBookmarkData()}
                </div>
            </div>
            </div>
        )
    }    
}
 
 export default BookmarkPage;