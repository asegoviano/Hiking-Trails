/**
 * Angel Segoviano 
 * 1/25/2021
 * ProfilePage
 * js page for displaying users profile information
 */
import React from 'react';
import Navbar from './Navbar';
import { Tabs, Modal, Button } from 'react-bootstrap';
import Avatar from '../images/avatar.png';
import FormInput from './FormInput';
import Axios from 'axios';

class ProfilePage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            show:false,
            // userData: [{
            //     firstName= "",
            //     lastName="",
            //     email="",
            //     username="",
            //     password=""
            // }]   
            userProfile: [{
                firstName: "",
                lastName: "",
                email: "",
                username: "",
                password: ""
            }],     
        };
    }    

    handleModal() {
        this.setState({show:true})
    }

    closeModal() {
        this.setState({show:!this.state.show})
    }

    async getUserID() {
        const res = await Axios.get('http://localhost:8080/userapi/editUser')
        this.setState({userProfile: res.data})
    }

    componentDidMount() {
        this.getUserID()
    }

    renderUserProfile() {
        return this.state.userProfile.map((user, index) => {
            const{id, firstName, lastName, email, username, password} = user
            return (
                <Button></Button>
            )
        })
    }

    render() {
        return (
            <div>
                <Navbar />
                <div>
                    <h1>My Profile </h1>
                    <img className="avatar" src={Avatar}/>

                    <Button className="editButton" onClick={()=>{this.handleModal()}}>Edit MyProfile</Button>
                        <Modal show={this.state.show}>
                            <Modal.Header>Edit MyProfile</Modal.Header>
                                <FormInput id="firstName" placeholder="First Name"/>
                                <FormInput id="lastName" placeholder="Last Name"/>
                                <FormInput id="email" placeholder="Email"/>
                                <FormInput id="username" placeholder="Username"/>
                                <FormInput id="password" placeholder="Password"/>
                            <Modal.Footer>
                                <Button>Save</Button>
                                <Button onClick={()=>{this.closeEditModal()}}>Cancel</Button>
                            </Modal.Footer>
                        </Modal>

                </div>

            </div>
        )
    }


    
}

export default ProfilePage;