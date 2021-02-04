import React from 'react'

import Navbar from "./Navbar";

class HomePage extends React.Component {
    render() {
        return (
            <div>
                {/* displays the content from the navbar component */}
                <Navbar/>
                Welcome To The Home Page
            </div>
        )
    }
}

export default HomePage;