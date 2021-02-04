import React from 'react';
import './style.css';
import Axios from "axios";
import FormInput from './FormInput';

class LoginPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isLoginOpen: true, isRegisterOpen: false};
    }

    showLoginBox() {
        this.setState({isLoginOpen: true, isRegisterOpen: false});
    }

    showRegisterBox() {
        this.setState({isRegisterOpen: true, isLoginOpen: false});
    }
    
    render() {
        return (
            <div className="base-container">
                <div className="form-controller">
                    <div className="controller" onClick={this.showLoginBox.bind(this)}>
                        Login
                    </div>
                    <div className="controller" onClick={this.showRegisterBox.bind(this)}>
                        Register
                    </div>
                </div>
                <div className="form-container">

                    {this.state.isLoginOpen && <LoginBox />}
                    {this.state.isRegisterOpen && <RegisterBox />}
                </div>
            </div>
            )
    }
}

class LoginBox extends React.Component {

        state = {
            firstName: "firstname",
            lastName: "lastname",
            email: "email",
            role: "User",
            status: "Active",
            username: "username",
            password: "password"
        };
    updateusername = (t) => {
        this.setState({username: t});
        console.log("State of form = ", this.state);
    }
    updatepassword = (t) => {
        this.setState({password: t});
        console.log("State of form = ", this.state);
    }
     // create the user once the form has been submitted
     handleFormSubmit = (e) => {
        e.preventDefault();
        console.log("in handle form submit", this.state);
        this.loginUser(this.state);
    }
    //calls the spring rest service login method
    loginUser = async (user) => {
        console.log("entering login user method");
        Axios.post(`http://localhost:8080/userapi/authenticate`, user)
        .then(result => {
            console.log(result);
        })
        window.location.href = "/home";
    }

    render () {
        return ( 
        <div className="inner-container">
        <form onSubmit={this.handleFormSubmit}>
            <div className="box-header">
                Login
            </div>
            <div className="box">
                <FormInput id = "username" title = "Username" placeholder = "username" onChange={this.updateusername}/>
                <FormInput id = "password" title = "Password" placeholder = "password" onChange={this.updatepassword}/>

                <button type="submit" className="login-btn" >Login</button>
            </div>
            </form>
        </div>
        )
    }
}

class RegisterBox extends React.Component {

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

    render () {
        return ( 
            <div className="inner-container">
                <form onSubmit={this.handleFormSubmit}>
                <div className="box-header">
                    Register
                </div>
                <div className="box">
                    <FormInput id = "firstName" title = "First Name" placeholder = "first name" onChange={this.updatefirstName}/>
                    <FormInput id = "lastName" title = "Last Name" placeholder = "last name" onChange={this.updatelastName}/>
                    <FormInput id = "email" title = "Email" placeholder = "email" onChange={this.updateemail}/>
                    <FormInput id = "username" title = "Username" placeholder = "username" onChange={this.updateusername}/>
                    <FormInput id = "password" title = "Password" placeholder = "password" onChange={this.updatepassword}/>

                    <button type="submit" className="Register-btn">Register</button>
                </div>
                </form>
            </div>
        )
    }
}

export default LoginPage;