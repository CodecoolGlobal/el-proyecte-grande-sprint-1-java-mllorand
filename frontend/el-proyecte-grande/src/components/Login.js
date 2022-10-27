import React, {useContext, useState} from 'react';
import axios from "axios";

const Login = () => {
    const [username, setUsername] = useState(null);
    const [password, setPassword] = useState(null);

    const handleLogin = async (username, password) => {
        const response = await axios.post("/api/login", {
            'username': username,
            'password': password
        }, {
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            }
        });
        if (response) {
            localStorage.setItem('access_token', response.data['access_token']);
        }
    }

    return (
        <>
            <input type="text" onChange={event => setUsername(event.target.value)}/>
            <input type="text" onChange={event => setPassword(event.target.value)}/>
            <button onClick={() => handleLogin(username, password)}>login</button>
        </>
    );
};

export default Login;
