import axios from 'axios';


//connection to the Spring Boot application
export default axios.create({
    baseURL: 'http://localhost:8080'
});