import React from "react";
import FormInput from './FormInput';
import Axios from "axios";
import "./style.css";

class RegisterPage extends React.Component {

    //state holds the default data speceified below
   state = {
       firstName: "firstname",
       lastName: "lastname",
       email: "email",
       role: "User",
       status: "Active",
       username: "username",
       password: "password"
   }

   // the updates occur as the onchange method is executed when data is entered into the form and
    updatefirstName = (t) => {
       this.setState({firstName: t});
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
        console.log("in handle form submit", this.state);
        this.createUser(this.state);
    }

    //calls the spring rest service create method
    createUser = async (user) => {
        console.log("entering create user method");
        Axios.post(`http://localhost:8080/userapi/create`, user)
        .then(result => {
            console.log(result);
        })
        window.location.href = "/home";
    }
    testButton = (t) => {
        
    }
    
    render() {
        return ( <div className="base-container">
        <form onSubmit={this.handleFormSubmit}>
        <div className="form-group">
        <div className="header">Register</div>
        {/* when a change is made to the forminput it updates the form with the new data entered */}
            <FormInput id = "firstName" title = "First Name" placeholder = "first name" onChange={this.updatefirstName}/>
            <FormInput id = "lastName" title = "Last Name" placeholder = "last name" onChange={this.updatelastName}/>
            <FormInput id = "email" title = "Email" placeholder = "email" onChange={this.updateemail}/>
            <FormInput id = "username" title = "Username" placeholder = "username" onChange={this.updateusername}/>
            <FormInput id = "password" title = "Password" placeholder = "password" onChange={this.updatepassword}/>
        
        <button type="submit" className="btn btn-dark"> Register </button>
        </div>
        </form>        
        </div>
        )
    }
}

export default RegisterPage;