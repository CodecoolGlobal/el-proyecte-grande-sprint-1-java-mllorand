import React, {useContext, useEffect, useState} from 'react';
import axios from "axios";

const UserDetail = ({id, fieldName, fieldValue, userData, setUserData}) => {
		const [field, setField] = useState(fieldValue);
		const [visibility, setVisibility] = useState(userData[fieldName].visibility);

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

		const handleChangeVisibility = (value) => {
			let newUserData = {...userData}
			newUserData[fieldName].visibility = value;
			setVisibility(value);
			setUserData(newUserData);
		}

		const handleSaveBtn = (value) => {
			axiosPatch(fieldName, value, userData[fieldName].visibility)
		}


		return (
			<div className="usr-detail">
				<span className='field-label'>{fieldName}:</span>
				{
					fieldName !== 'gender' &&
					<input type='text' className='field' value={field}
								 onChange={e => handleChange(e.target.value)}
					></input>
				}
				{
					fieldName === 'gender' &&
					<select className="field" value={field}
									onChange={e => handleChange(e.target.value)}
					>
						<option value="MALE">Male</option>
						<option value="FEMALE">Female</option>
						<option value="OTHER">Other</option>
					</select>
				}
				<select className="visibility-lvl" value={visibility}
								onChange={e => handleChangeVisibility(e.target.value)}
				>
					<option value="PRIVATE">Private</option>
					<option value="PUBLIC">Public</option>
					<option value="GROUPS_ONLY">Groups only</option>
				</select>
				<button onClick={() => handleSaveBtn(field)}>
					update
				</button>
			</div>
		);
	}
;

export default UserDetail;
