import React from 'react';
import './style.css';

class Search extends React.Component {
 
        state = {
            setKeyword: ''
        }
    SearchBar = (e) => {
        this.setState({setKeyword: e.target.value});
        console.log("Connects of the searchbar = ",this.state.setKeyword);
        this.props.onChange(this.state.setKeyword);
    }

      render() {
          return(
            <div className="searchInput">
            <input className="searchBar"
              key="random1"
              value={this.props.keyword}
              placeholder={"Enter trail name..."}
              onChange={this.SearchBar}
              onBlur={this.SearchBar}
              id={this.props.id}
             />
             </div>
          )
      }

}

export default Search;