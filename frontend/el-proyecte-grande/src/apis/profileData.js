import axios from "axios";
const BASE_URL = '/api/cooperator';

export default (token) => axios.create({
	baseURL: BASE_URL,
	headers: {
		'Authorization': 'Bearer ' + token,
		'Content-Type': 'application/json',
		'Accept': 'application/json'
	}
});