import React, {useContext, useEffect, useState} from 'react';
import axios from "../../../apis/profileData";

const UserDetail = ({id, fieldName, fieldValue, userData, setUserData}) => {
	const [field, setField] = useState(fieldValue);

	const axiosPut = (fieldName, fieldValue) => {
		axios.put(`http://localhost:8080/profile/2/${fieldName}`, {
			"attributeValue": fieldValue,
			"visibility": "PRIVATE"
		})
	}

	const handleChange = (value) => {
		let newUserData = {...userData}
		newUserData[fieldName].attributeValue = value;
		setField(value);
		setUserData(newUserData);
	}

	const handleSaveBtn = (value) => {
		save(fieldName, value)
	}


	return (
		<div className="usr-detail">
			<span className='field-label'>{fieldName}:</span>
			<input type='text' className='field' value={field}
						 onChange={(e) => handleChange(e.target.value)}></input>
			<button onClick={(e) => handleSaveBtn(e.target.value)}></button>
		</div>
	);
}
;

export default UserDetail;
