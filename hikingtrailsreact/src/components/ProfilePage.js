import React from 'react';
import Navbar from './Navbar';
import Avatar from '../images/avatar.png';

class ProfilePage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }    

    render() {
        return (
            <div>
            <Navbar />
        <div>
            Welcome to Profile Page
        </div>
        <div>
            <h1>My Profile </h1>
            <img className="avatar" src={Avatar}/>
            <ul>
                <li>Full Name</li>
                <li>Username</li>
                <li>Password</li>
                <li>Email</li>
            </ul>
        </div>

        </div>
        )
    }
}

export default ProfilePage;