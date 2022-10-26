import axios from "axios";
const BASE_URL = 'http://localhost:8080/cooperator';

export default () => axios.create({
	baseURL: BASE_URL,
	headers: {
		'Authorization': 'Bearer ' + localStorage.getItem('access_token'),
		'Content-Type': 'application/json',
		'Accept': 'application/json'
	}
});