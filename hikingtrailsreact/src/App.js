/**
 * Angel Segoviano 
 * 12/10/2020
 * App
 * contrains the routes for each page
 */
import React from 'react';
import LoginPage from './components/LoginPage';
import HomePage from './components/HomePage';
import AdminPage from './components/AdminPage';
import ProfilePage from './components/ProfilePage';
import ExplorePage from './components/ExplorePage';
import BookmarkPage from './components/BookmarkPage';
import EventPage from './components/EventPage';
import { createBrowserHistory } from "history";
import {Router, Route, Switch} from 'react-router-dom';

const history = createBrowserHistory();
class App extends React.Component {

    state = {passUserId: "1", role:"", user: false, alert:1}
    callbackFunction = (userData, userRole) => {
        console.log("in callbackfuction");
        this.setState({passUserId: userData})
        this.setState({role: userRole})
        this.setState({user: true})
    }
    testMethod(){
        this.setState({alert: 1});
    }

    render() {

        // creates the routes to access the pages listed below 
        return (
            
            <Router history = {history}>
                <div>
                    <Switch>
                    <Route exact path ="/" render = { () => (this.state.user ? <HomePage  dataFormParent={this.state}/> :  <LoginPage callmethod = {this.callbackFunction}/>)
                        }/>
                    </Switch>
                    <Switch>
                       <Route exact path ="/home" render = { () => (this.state.user ? <HomePage  dataFormParent={this.state}/> : <LoginPage dataFormParent={this.state.alert} callmethod = {this.callbackFunction}/>)
                        }/>
                    </Switch>
                    <Switch>
                       <Route exact path ="/Admin" render = { () => (this.state.user ? <AdminPage  dataFormParent={this.state}/> : <LoginPage dataFormParent={this.state.alert} callmethod = {this.callbackFunction}/>)
                        }/>
                    </Switch>
                    <Switch>
                       <Route exact path ="/Profile" render = { () => (this.state.user ? <ProfilePage  dataFormParent={this.state}/> : <LoginPage dataFormParent={this.state.alert} callmethod = {this.callbackFunction}/>)
                        }/>
                    </Switch>
                    <Switch>
                       <Route exact path ="/Explore" render = { () => (this.state.user ? <ExplorePage  dataFormParent={this.state}/> : <LoginPage dataFormParent={this.state.alert} callmethod = {this.callbackFunction}/>)
                        }/>
                    </Switch>
                    <Switch>
                       <Route exact path ="/Bookmark" render = { () => (this.state.user ? <BookmarkPage  dataFormParent={this.state}/> : <LoginPage dataFormParent={this.state.alert} callmethod = {this.callbackFunction}/>)
                        }/>
                    </Switch>
                    <Switch>
                       <Route exact path ="/Event" render = { () => (this.state.user ? <EventPage  dataFormParent={this.state}/> : <LoginPage dataFormParent={this.state.alert} callmethod = {this.callbackFunction}/>)
                        }/>
                    </Switch>
                </div>
            </Router>
        )
    }
}

export default App;