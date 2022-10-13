import {createContext, useState} from "react";

export const CooperatorContext = createContext();


export const CooperatorContextProvider = ({children}) => {
	const [showModal, setShowModal] = useState(false);


	return (
		<CooperatorContext.Provider value={[showModal, setShowModal]}>
			{children}
		</CooperatorContext.Provider>
	)
}