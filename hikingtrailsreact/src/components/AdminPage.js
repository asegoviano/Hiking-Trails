/**
 * Angel Segoviano 
 * 2/7/2021
 * AdminPage
 * js page for Admin Page
 */
import React from 'react';
import Navbar from './Navbar';
import Axios from "axios";
import {Table, Button} from 'react-bootstrap';

class AdminPage extends React.Component {

    constructor() {
        super();
        this.state = {
            tableData: [{
                username: "",
                email: "",
                role: "",
                status: "",
            }],
        };
    }

    //calls the rest service call for finding all users from the Spring boot application using the url
    async getUsersData(){
        const res = await Axios.get('http://localhost:8080/userapi/findAll')
        console.log(res.data)
        this.setState({tableData: res.data})
    }
    componentDidMount(){
        this.getUsersData()
    }

    //calls the rest service call for deleting a user from the spring boot application using the url
    deleteUser = (id) => {
        Axios.delete('http://localhost:8080/userapi/delete/' + id)
        .then(response => {
            if(response.data != null) {
                alert("The user was deleted successfully.");
                //working on a better form of updating the table without rerouting the user to the same page/another page
                // this.setState({
                //     id: this.state.user.filter(id => tableData.id !== id)
                // });
            }
        })
        //routes user to admin page
        window.location.href = "/Admin";
      }

    // method is used for changing a users status from active to suspended or the other way around.
    changeUserStatus = (user) => {
        //checks if users status is active
        if(user.status === "Active") {
            // change user status from active to suspended
            user.status = "Suspended"
            console.log("User status was changed,",user.status);
        }
        else {
            //if users status is set to suspended then change to Active
            user.status = "Active"
            console.log("User Status was changed,",user.status);
        }
        //calls the rest service call for editing a user in order to change the users status 
        Axios.post('http://localhost:8080/userapi/editUser', user)
        .then(result => {
            console.log(result);
        })
        //routes user to admin
        window.location.href = "/Admin";
    }      

    //this method is responsible for populating the table with the users data using the getUsersData
      renderTableData() {
          return this.state.tableData.map((user,index) => {
              const{id, username, email, role, status} = user
              return (
                //   gets the users id, username, email, role and status 
                  <tr key={id}>
                      <td>{username}</td>
                      <td>{email}</td>
                      <td>{role}</td>
                      {/* calls the changeUserStatus method */}
                      <td><Button variant="primary" onClick={this.changeUserStatus.bind(this, user)}>{status}</Button></td>
                      {/* calls the deleteUser method  */}
                      <td><Button variant="danger" onClick={this.deleteUser.bind(this, user.id)} >Remove</Button></td>
                  </tr>
              )
          })
      }

    render () {
        return  (
            <div>
                <Navbar />
            <div className="pageTitle">
                Administrator Page
            </div>
            <Table className="reactTable" striped border hover>    
            <thead>
                    <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Status</th>
                    <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    {/* calls the renderTableData for populating all columns with the users info. */}
                    {this.renderTableData()}
                </tbody>
            </Table>
            </div>
         )
    }
}

export default AdminPage;