/**
 * Angel Segoviano 
 * 12/10/2020
 * HomePage
 * js page for homePage
 */
import React from 'react'
import {Carousel, Container, Row, Col, Image} from 'react-bootstrap';
import Navbar from "./Navbar";
import trail1 from '../images/trail1.jpg';
import trail2 from '../images/trail2.jpg';
import trail3 from '../images/trail3.jpg';
import trail4 from '../images/trail4.jpg';
import bookmarkIcon from '../images/bookmarkIcon.png';
import searchIcon from '../images/searchIcon.png';

class HomePage extends React.Component {
    render() {
        return (
            <div>
                <Navbar/>
                    <h1>Welcome Page</h1>
                    <Container>
                        <Row className="rowCSSC">
                        <Carousel interval={2000} keyboard={false} pauseOnHover={false}>
                            <Carousel.Item style={{'height':"400px", 'width':"1000px"}} >
                                <img style={{'height':"400px", 'width':"1000px"}} className="d-block w-100" src={trail1} alt="Trail"/>
                            </Carousel.Item>
                            <Carousel.Item style={{'height':"400px", 'width':"1000px"}} >
                                <img style={{'height':"400px", 'width':"1000px"}} className="d-block w-100" src={trail2} alt="Trail"/>
                            </Carousel.Item>
                            <Carousel.Item style={{'height':"400px", 'width':"1000px"}} >
                                <img style={{'height':"400px", 'width':"1000px"}} className="d-block w-100" src={trail3} alt="Trail" />
                            </Carousel.Item>
                            <Carousel.Item style={{'height':"400px", 'width':"1000px"}} >
                                <img style={{'height':"400px", 'width':"1000px"}} className="d-block w-100" src={trail4} alt="Trail" />
                            </Carousel.Item>
                        </Carousel>
                    </Row>
                    <Row className="rowCSS">
                        <Col xs={6} md={4}>
                            <Image className="bookmarkIcon" src={bookmarkIcon} alt="bookmarkIcon" roundedCircle/>
                            <text>testing </text>
                        </Col>
                        <Col xs={6} md={4}>
                            <Image className="searchIcon" src={searchIcon} alt="searchIcon" roundedCircle/>
                        </Col>
                    </Row>
                </Container>
            </div>
        )
    }
}

export default HomePage;