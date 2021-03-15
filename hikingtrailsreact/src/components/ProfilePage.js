/**
 * Angel Segoviano 
 * 1/25/2021
 * ProfilePage
 * js page for displaying users profile information
 */
import React from 'react';
import Navbar from './Navbar';
import { Modal, Button } from 'react-bootstrap';
import Avatar from '../images/avatar.png';
import FormInput from './FormInput';
import Axios from 'axios';

class ProfilePage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            show:false,
            userProfile: {
                id: this.props.dataFormParent.passUserId,
                firstName: "",
                lastName: "",
                email: "",
                username: "",
                role: "",
                password: "",
                status:""
            },     
        };
    }    

    handleModal() {
        this.setState({show:true})
    }

    closeModal() {
        this.setState({show:!this.state.show})
    }

    updatefirstName = (t) => {
        this.setState({firstName: t});
        this.setState({id: this.props.dataFormParent.passUserId});
        this.setState({role:  this.state.userProfile.role})
        this.setState({status:  this.state.userProfile.status})
        console.log("state of form = ", this.state);
     }
    
     updatelastName = (t) => {
         this.setState({lastName: t});
         console.log("state of form = ", this.state);
     }
 
     updateemail = (t) => {
         this.setState({email: t});
         console.log("state of form = ", this.state);
     }
 
     updateusername = (t) => {
         this.setState({username: t});
         console.log("state of form = ", this.state);
     }
 
     updatepassword = (t) => {
         this.setState({password: t});
         console.log("state of form = ", this.state);
     }
 
     // create the user once the form has been submitted
     handleFormSubmit = (e) => {
         e.preventDefault();
         console.log("in handle editform submit", this.state);
       
         this.editUser(this.state);
     }

    async getUserID() {
        const res = await Axios.get(`http://localhost:8080/userapi/findByUserId/${this.state.userProfile.id}`)
        this.setState({userProfile: res.data})
        console.log("data set + collected ", this.state.userProfile)
    }

    editUser = async (user) => {
        console.log("IN HERE", user)
        Axios.post(`http://localhost:8080/userapi/editUser`, user)

    }

    componentDidMount() {
        this.getUserID()
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
                        <form onSubmit={this.handleFormSubmit}>
                            <Modal.Header>Edit MyProfile</Modal.Header>
                                <FormInput id="firstName" title="First Name" placeholder={this.state.userProfile.firstName} onChange={this.updatefirstName} default={this.state.userProfile.firstName}/>
                                <FormInput id="lastName" title="Last Name" placeholder={this.state.userProfile.lastName} onChange={this.updatelastName} default={this.state.userProfile.lastName}/>
                                <FormInput id="email" title="Email" placeholder={this.state.userProfile.email} onChange={this.updateemail} default={this.state.userProfile.email}/>
                                <FormInput id="username" title="Username" placeholder={this.state.userProfile.username} onChange={this.updateusername} default={this.state.userProfile.username}/>
                                <FormInput id="password" title="Password" placeholder={this.state.userProfile.password} onChange={this.updatepassword} default={this.state.userProfile.password}/>
                            <Modal.Footer>
                                <Button type="submit">Save</Button>
                                <Button onClick={()=>{this.closeModal()}}>Cancel</Button>
                            </Modal.Footer>
                            </form>
                        </Modal>
                    
                </div>

            </div>
        )
    }   
}

export default ProfilePage;