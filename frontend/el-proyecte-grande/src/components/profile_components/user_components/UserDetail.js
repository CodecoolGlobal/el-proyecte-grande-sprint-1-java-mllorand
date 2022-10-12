import React, {useEffect, useState} from 'react';
import axios from "../../../apis/profileData";

const UserDetail = ({id, fieldName, fieldValue, userData, setUserData}) => {
		const [field, setField] = useState(fieldValue);

		const handleChange = (value) => {
			let newUserData = {...userData}
			newUserData[fieldName].attributeValue = value;
			setField(value);
			setUserData(newUserData);
		}

		return (
			<div className="usr-detail">
				<span className='field-label'>{fieldName}:</span>
				<input type='text' className='field' value={field}
							 onChange={(e) => handleChange(e.target.value)}></input>
			</div>
		);
	}
;

export default UserDetail;
