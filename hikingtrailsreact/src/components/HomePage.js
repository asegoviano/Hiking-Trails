/**
 * Angel Segoviano 
 * 12/10/2020
 * HomePage
 * js page for homePage
 */
import React from 'react'
import Navbar from "./Navbar";
import Trail from '../images/trail3.jpg';

class HomePage extends React.Component {
    render() {
        return (
            <div>
                {/* displays the content from the navbar component */}
                <Navbar/>
                Welcome To The Home Page
                {/* <img className="trail" src={Trail}/> */}
            </div>
        )
    }
}

export default HomePage;