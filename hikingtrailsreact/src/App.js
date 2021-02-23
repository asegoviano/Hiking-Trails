/**
 * Angel Segoviano 
 * 12/10/2020
 * App
 * contrains the routes for each page
 */
import React from 'react';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import HomePage from './components/HomePage';
import AdminPage from './components/AdminPage';
import ProfilePage from './components/ProfilePage';
import ExplorePage from './components/ExplorePage';
import { createBrowserHistory } from "history";
import {Router, Route, Switch} from 'react-router-dom';

const history = createBrowserHistory();
class App extends React.Component {

    state = {passUserId: "111", role:"111", user: false}
    callbackFunction = (userData, userRole) => {
        console.log("in callbackfuction");
        this.setState({passUserId: userData})
        this.setState({role: userRole})
        this.setState({user: true})
    }

    render() {

        // creates the routes to access the pages listed below 
        return (
            
            <Router history = {history}>
                <div>
                    <Switch> 
                    <Route exact path ="/" render = { () =>{ return (
                            <LoginPage callmethod = {this.callbackFunction}/>
                        )}}/>
                    </Switch>
                    <Route exact path ="/login" render = { () => (this.state.user ? <HomePage  dataFormParent={this.state}/> :  <LoginPage callmethod = {this.callbackFunction}/>)
                        }/>
                    <Switch>
                        <Route exact path ="/Register" render = { () =>{ return (
                            <RegisterPage/>
                        )}}/>
                    </Switch>
                    <Switch>
                        <Route exact path ="/home" render = { () =>(
                            <HomePage dataFormParent={this.state}/>
                       )}/>
                    </Switch>
                    <Switch>
                        <Route exact path ="/Admin" render = { () =>{ return (
                            <AdminPage/>
                       )}}/>
                    </Switch>
                    <Switch>
                        <Route exact path ="/Profile" render = { () =>{ return (
                            <ProfilePage/>
                       )}}/>
                    </Switch>
                    <Switch>
                        <Route exact path ="/Explore" render = { () =>{ return (
                            <ExplorePage/>
                       )}}/>
                    </Switch>
                </div>
            </Router>
        )
    }
}

export default App;