/**
 * Angel Segoviano 
 * 12/10/2020
 * Navbar
 * js page for displaying navbar
 */
import React from 'react'
import { Link } from 'react-router-dom';

//method for displaying and routing the navbar 
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
                <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
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
                            <span className="nav-link" href="#"><Link to="/bookmark">My Bookmarks</Link></span>
                            <span className="nav-link" href="#"><Link to="/event">My Events</Link></span>
                            <span className="nav-link" href="#"><Link to="/admin">Admin</Link></span>
                            <span className="nav-link" href="#"><Link to="/">Logout</Link></span>
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