import React from 'react';

class FormInput extends React.Component {
    state={inputData: ""};
    //sets the default data in the form and once new data is entered onchange event is excuted
    handleChangeData = (e) => {
        this.setState({inputData : e.target.value});
        console.log("connects of the input = ", this.state.inputData);
        this.props.onChange(this.state.inputData);
    }

    render() {
        return (
            <div>
                {/* onchange event is responsible for checking if the form has been updated and storing the new data */}
                <label htmlFor={this.props.id}>{this.props.title} </label> 
                <input onChange={this.handleChangeData} onBlur={this.handleChangeData} type="text" className="form-control" id={this.props.id} placeholder={this.props.placeholder} />
            </div>
        )
    }
}

export default FormInput;