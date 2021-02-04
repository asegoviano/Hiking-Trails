import React from 'react'
//imports the routes created in the App.js that are referenced in the navbar
import { Link } from 'react-router-dom';

class Navbar extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            
        }
    }
    render() {
        return (
            <div>
                <header>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <div className="container-fluid">
                        <span className="navbar-brand" href="#">HikingTrails</span>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div className="navbar-nav">
                            <span className="nav-link" href="#"><Link to="/home">Home</Link></span>
                            <span className="nav-link" href="#"><Link to="/profile">Profile</Link></span>
                            <span className="nav-link" href="#"><Link to="/explore">Exlpore</Link></span>
                            <span className="nav-link" href="#"><Link to="/admin">Admin</Link></span>
                            <span className="nav-link" href="#"><Link to="/login">Logout</Link></span>
                        </div>
                        </div>
                    </div>
                </nav>
                </header>
            </div>
        )
    }
}

export default Navbar;