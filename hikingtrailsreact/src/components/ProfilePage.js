import React from 'react';
import Navbar from './Navbar';

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