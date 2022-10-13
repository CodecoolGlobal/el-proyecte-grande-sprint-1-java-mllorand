import React, {useContext, useEffect, useState} from 'react';
import axios from "axios";

const UserDetail = ({id, fieldName, fieldValue, userData, setUserData}) => {
	const [field, setField] = useState(fieldValue);

	const axiosPatch = (fieldName, fieldValue, visibility) => {
		axios.patch(`/profile/2/${fieldName}`, {
			"attributeValue": fieldValue,
			"visibility": visibility
		})
	}

	const handleChange = (value) => {
		let newUserData = {...userData}
		newUserData[fieldName].attributeValue = value;
		setField(value);
		setUserData(newUserData);
	}

	const handleSaveBtn = (value) => {
		axiosPatch(fieldName, value, userData[fieldName].visibility)
	}


	return (
		<div className="usr-detail">
			<span className='field-label'>{fieldName}:</span>
			<input type='text' className='field' value={field}
						 onChange={(e) => handleChange(e.target.value)}></input>
			<button onClick={() => handleSaveBtn(field)}>
				update
			</button>
		</div>
	);
}
;

export default UserDetail;
