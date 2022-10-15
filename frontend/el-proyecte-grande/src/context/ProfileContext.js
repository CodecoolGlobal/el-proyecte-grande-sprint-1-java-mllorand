import {createContext, useState} from "react";

export const ProfileContext = createContext();

export const ProfileContextProvider = ({children}) => {
	const [userData, setUserData] = useState(null);
	const [cooperatorData, setCooperatorData] = useState(null);
	const [labels, setLabels] = useState(null);

	return (
		<ProfileContext.Provider value={{
			userData,
			setUserData,
			cooperatorData,
			setCooperatorData,
			labels,
			setLabels
		}}>
			{children}
		</ProfileContext.Provider>
	)
}