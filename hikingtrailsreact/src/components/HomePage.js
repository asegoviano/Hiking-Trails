/**
 * Angel Segoviano 
 * 12/10/2020
 * HomePage
 * js page for homePage
 */
import React from 'react'
import { Container, Row, Col, Image} from 'react-bootstrap';
import Navbar from "./Navbar";
import bookmarkIcon from '../images/bookmarkIcon.png';
import searchIcon from '../images/searchIcon.png';
import tr1 from '../images/tr1.jpg';

class HomePage extends React.Component {
    render() {
        return (
            <div>
                <Navbar/>
                    <Container>
                        <Row className="rowCSSC">
                                <img style={{'height':"425px", 'width':"400px"}} className="d-block w-100" src={tr1} alt="Trail"/>
                        </Row>
                    <Row className="rowCSS">
                            <Col xs={6} md={4}>
                                <Image className="bookmarkIcon" src={bookmarkIcon} alt="bookmarkIcon" height='100px' width='120px'/>
                                <Row>
                                    <text>Check out your favorites by adding a trail to your favorites from the Explore Page!</text>
                                </Row>
                            </Col>
                            <Col xs={6} md={4}>
                                <Image className="searchIcon" src={searchIcon} alt="searchIcon" roundedCircle/>
                                <Row>
                                    <text>Go to the Explore Page and search through a list of trails and see which one looks fun!</text>
                                </Row>
                            </Col>
                    </Row>
                </Container>
            </div>
        )
    }
}

export default HomePage;