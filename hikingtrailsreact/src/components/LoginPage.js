/**
 * Angel Segoviano 
 * 1/2/2021
 * LoginPage
 * js page for login and registering a user
 */
import React from 'react';
import './style.css';
import Axios from "axios";
import FormInput from './FormInput';
import {Button} from 'react-bootstrap';
import Alert from 'react-bootstrap/Alert';

class LoginPage extends React.Component {
    
    state = {isLoginOpen: true, isRegisterOpen: false, id:"", role:"", alert: 0};

    //displays the login form if the register form is not being displayed
    showLoginBox() {
        this.setState({isLoginOpen: true, isRegisterOpen: false});
    }

    //displays the register form if the the login form is being displayed
    showRegisterBox() {
        this.setState({isRegisterOpen: true, isLoginOpen: false});
    }

    test = (passid, passrole) => {
        this.setState({id: passid})
        this.setState({role: passrole})
        this.props.callmethod(this.state.id, this.state.role);
    }
    
    componentDidMount(){
        this.setState({alert: this.props.dataFormParent});
        console.log(this.props.dataFormParent);
    }
    render() {
        return (
            <div className="base-container" >
                {this.state.alert === 1 ? <Alert variant="danger" style={{marginTop: '2%'}}>Please Login First to access the website!</Alert> : <br/>}
                <div className="form-controller">
                    <div className="controller" onClick={this.showLoginBox.bind(this)} required >
                        Login
                    </div>
                    <div className="controller" onClick={this.showRegisterBox.bind(this)} required >
                        Register
                    </div>
                </div>
                <div className="form-container">

                    {this.state.isLoginOpen && <LoginBox testmethod = {this.test}/>}
                    {this.state.isRegisterOpen && <RegisterBox />}
                </div>
            </div>
            )
        }
    }

    //validation for all form inputs on both login and register forms
    function validate(firstName, lastName, email, username, password) {
        const errors = [];

        if (firstName.length < 2) {
            errors.push("Firstname is required.");
        }
        if (lastName.length < 2) {
            errors.push("LastName is required.");
        }
        if (email.length === 0) {
            errors.push("Email is required.");
        }
        if (username.length < 4) {
            errors.push("Username is required.");
        }
        if (password.length < 4) {
            errors.push("Password is required.");
        }
        return errors;
    }

    //login class contianing the logic for login and displaying the form
    class LoginBox extends React.Component {
        //objects 
            state = {
                firstName: "firstname",
                lastName: "lastname",
                email: "email",
                role: "User",
                status: "Active",
                username: "",
                password: "",
                errors: [],
                alert: 0
            };
        //takes in the username that was entered into the form for the username field
        updateusername = (t) => {
            this.setState({username: t});
            console.log("State of form = ", this.state);
        }
        //takes in the password that was enetered into the form for the password field
        updatepassword = (t) => {
            this.setState({password: t});
            console.log("State of form = ", this.state);
        }
        // create the user once the form has been submitted
        handleFormSubmit = (e) => {
            e.preventDefault();
            console.log("in handle form submit", this.state);
            const {firstName, lastName, email, username, password} = this.state;
            //calls the validate method and checks if all fields are meet the parameters that were set for validation
            const errors = validate(firstName, lastName, email, username, password);
            if(errors.length > 0) {
                this.setState({errors});
                return;
            }
            //logs in user
            this.loginUser(this.state);
        }
        //calls the spring rest service login method
        async loginUser(user){
            const result = await Axios.post("http://localhost:8080/userapi/authenticate", user)
            this.setState({role : result.data.role});
            this.setState({status : result.data.status});
            this.setState({id : result.data.id});
            if(this.state.status === "Suspended") {
                alert("You're account has been suspended.")
            } else {
                this.props.testmethod(this.state.id, this.state.role);
            }
        }

        render () {
            const {errors} = this.state;
            return ( 
            <div className="inner-container">
            <form onSubmit={this.handleFormSubmit}>
                    {errors.map(error => ( 
                        <p key={error}>Error: {error}</p>
                    ))}
                <div className="box-header">
                    Login
                </div>
                <div className="box">
                    <FormInput id = "username" title = "Username" placeholder = "username" onChange={this.updateusername}/>
                    <FormInput id = "password" type="password" title = "Password" placeholder = "password" onChange={this.updatepassword}/>
                    <Button type="submit" className="login-btn" variant="primary">Login</Button>
                </div>
                </form>
            </div>
        )
    }
}

class RegisterBox extends React.Component {

    //state holds the default data speceified below
    state = {
        firstName: "",
        lastName: "",
        email: "",
        role: "User",
        status: "Active",
        username: "",
        password: "",
        errors: []
    }

    // the updates occur as the onchange method is executed when data is entered into the form for the firstname
    updatefirstName = (t) => {
        this.setState({firstName: t});
        console.log("state of form = ", this.state);
    }

    // the updates occur as the onchange method is executed when data is entered into the form for the lastname
    updatelastName = (t) => {
        this.setState({lastName: t});
        console.log("state of form = ", this.state);
    }

    // the updates occur as the onchange method is executed when data is entered into the form for the email
    updateemail = (t) => {
        this.setState({email: t});
        console.log("state of form = ", this.state);
    }

    // the updates occur as the onchange method is executed when data is entered into the form for the username
    updateusername = (t) => {
        this.setState({username: t});
        console.log("state of form = ", this.state);
    }

    // the updates occur as the onchange method is executed when data is entered into the form for the password
    updatepassword = (t) => {
        this.setState({password: t});
        console.log("state of form = ", this.state);
    }

    // create the user once the form has been submitted
    handleFormSubmit = (e) => {
        e.preventDefault();
        console.log("in handle form submit", this.state);
        const {firstName, lastName, email, username, password} = this.state;
        //calls the validate method and checks if all fields are meet the parameters that were set for validation
        const errors = validate(firstName, lastName, email, username, password);
        if(errors.length > 0) {
            this.setState({errors});
            return;
        }
        //user is created
        this.createUser(this.state);
    }

    //calls the spring rest service create method
    createUser = async (user) => {
        console.log("entering create user method");
        Axios.post(`http://localhost:8080/userapi/create`, user)
        .then(result => {
            console.log(result);
        })
        //user is routed home
        window.location.href = "/home";
    }

    render () {
        const {errors} = this.state;
        return ( 
            <div className="inner-container">
                {/* calls the handle form submit method */}
                <form onSubmit={this.handleFormSubmit}>
                    {errors.map(error => ( 
                        <p key={error}>Error: {error}</p>
                    ))}
                <div className="box-header">
                    Register
                </div>
                <div className="box">
                    <FormInput id = "firstName" title = "First Name" placeholder = "first name" onChange={this.updatefirstName}/>
                    <FormInput id = "lastName" title = "Last Name" placeholder = "last name" onChange={this.updatelastName}/>
                    <FormInput id = "email" title = "Email" placeholder = "email" onChange={this.updateemail}/>
                    <FormInput id = "username" title = "Username" placeholder = "username" onChange={this.updateusername}/>
                    <FormInput id = "password" title = "Password" type="password" placeholder = "password" onChange={this.updatepassword}/>

                    <Button type="submit" className="Register-btn" variant="primary" >Register</Button>
                </div>
                </form>
            </div>
        )
    }
}

export default LoginPage;