import {createContext, useEffect, useState} from "react";

export const AuthContext = createContext();

export const AuthContextProvider = ({children}) => {
	const [authToken, setAuthToken] = useState(null);

	useEffect(() => {
		const accessToken = localStorage.getItem('authToken');
		if (!(accessToken === null)) setAuthToken(accessToken);
	}, [])

	const saveAuthToken = (authToken) => {
		localStorage.setItem('authToken', authToken);
		setAuthToken(authToken);
	}

	return (
		<AuthContext.Provider value={{
			authToken: authToken,
			setAuthToken: saveAuthToken
		}}>
			{children}
		</AuthContext.Provider>
	)
}