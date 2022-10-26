import React, {useContext, useState} from 'react';
import axios from "axios";
import {AuthContext} from "../context/AuthContext";

const Login = () => {
    const [username, setUsername] = useState(null);
    const [password, setPassword] = useState(null);
    const {setAuthToken} = useContext(AuthContext);

    const login = async (username, password) => {
        const response = await axios.post("/api/login", {
            'username': username,
            'password': password
        }, {
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            }
        });
        if (response) {
            console.log('login')
            console.log(response.data['access_token'])
            setAuthToken(response.data['access_token']);
        }
    }

    return (
        <>
            <input type="text" onChange={event => setUsername(event.target.value)}/>
            <input type="text" onChange={event => setPassword(event.target.value)}/>
            <button onClick={() => login(username, password)}>login</button>
        </>
    );
};

export default Login;
