import React, {useContext, useState} from 'react';
import axios from "axios";
import {AuthContext} from "../context/AuthContext";

const Login = () => {
	// const [username, setUsername] = useState(null);
	// const [password, setPassword] = useState(null);
	const {setAuthToken} = useContext(AuthContext);
	//
	// const login = async (username, password) => {
	// 	const response = await axios.post("http://localhost:8080/login", {
	// 		'username': username,
	// 		'password': password
	// 	}, {
	// 		headers:{
	// 			"Content-Type": "application/x-www-form-urlencoded"
	// 		}
	// 	});
	// 	console.log(response)
	// 	setAuthToken(response['access_token']);
	// }

	return (
		<>
			<form action="http://localhost:8080/login">
				<input type="text" name='username'/>
				<input type="text" name='password'/>
				<button type='submit'>gomb</button>
			</form>
			{/*<input type="text" onChange={event => setUsername(event.target.value)}/>*/}
			{/*<input type="text" onChange={event => setPassword(event.target.value)}/>*/}
			{/*<button onClick={() => login(username, password)}>login</button>*/}
		</>
	);
};

export default Login;
