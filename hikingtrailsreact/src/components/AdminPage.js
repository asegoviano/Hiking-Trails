import React from 'react';
import Navbar from './Navbar';
import Axios from "axios";
import Table from 'react-bootstrap/Table';

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

    async getUsersData(){
        const res = await Axios.get('http://localhost:8080/userapi/findAll')
        console.log(res.data)
        this.setState({tableData: res.data})
      }
      componentDidMount(){
        this.getUsersData()
      }

    deleteUser = (id) => {
        Axios.delete('http://localhost:8080/userapi/delete/' + id)
        .then(response => {
            if(response.data != null) {
                alert("The user was deleted successfully.");
                // this.setState({
                //     id: this.state.user.filter(id => tableData.id !== id)
                // });
            }
        })
      }

     async userStatus (id){
        const res = await Axios.get('http://localhost:8080/userapi/editUser' + id).then(response => {
            
        })
      }
      

      renderTableData() {
          return this.state.tableData.map((user,index) => {
              const{id, username, email, role, status} = user
              return (
                  <tr key={id}>
                      <td>{username}</td>
                      <td>{email}</td>
                      <td>{role}</td>
                      <td><button onClick={this.userStatus.bind(this,user.id, user.status)}>{status}</button></td>
                      <td><button onClick={this.deleteUser.bind(this, user.id)} >Remove</button></td>
                  </tr>
              )
          })
      }

    render () {

        return  (
            <div>
                <Navbar />
            <div>
                Welcome Admin
            </div>
            <Table>    
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
                    {this.renderTableData()}
                </tbody>
            </Table>
            </div>
         )
    }
}

export default AdminPage;