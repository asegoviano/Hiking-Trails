import Axios from 'axios';
import React from 'react';
import Navbar from './Navbar';
import Card from 'react-bootstrap/Card';

class ExplorePage extends React.Component {

    constructor() {
        super ();
        this.state ={
            trailData: [{
                trailName: "",
                city: "",
                state: "",
                trailDistance: "",
            }],
        };
    }

    async getTrailData(){
        const res = await Axios.get('http://localhost:8080/trailapi/findAll')
        console.log(res.data)
        this.setState({trailData: res.data})
    }
    componentDidMount(){
        this.getTrailData()
    }

    renderTrailData() {
        return (
                <div>
                </div>
        )
    }

    render() {
        return (
            <div>
                <Navbar />
                Testing Explore explore page
            </div>
        )

    }
}

export default ExplorePage;