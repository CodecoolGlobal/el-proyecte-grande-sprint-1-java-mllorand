import React, {useContext, useEffect, useState} from 'react';
import axios from "axios";
import {ProfileContext} from "../../../context/ProfileContext";

const UserDetail = ({fieldName}) => {
		const {userData, setUserData} = useContext(ProfileContext);
		const [field, setField] = useState(fieldName === 'name' ? userData[fieldName] : userData[fieldName].attributeValue);
		const [visibility, setVisibility] = useState(fieldName === "name" ? true : userData[fieldName].visibility);
		const axiosPatch = (fieldName, fieldValue, visibility) => {
			if (fieldName === "name") {
				axios.patch(`/${fieldName}`, {
					"attributeValue": fieldValue
				})
			} else {
				axios.patch(`/${fieldName}`, {
					"attributeValue": fieldValue,
					"visibility": visibility
				})
			}
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

				{
					fieldName !== 'name' &&
					<select className="visibility-lvl" value={visibility}
									onChange={e => handleChangeVisibility(e.target.value)}
					>
						<option value="PRIVATE">Private</option>
						<option value="PUBLIC">Public</option>
					</select>
				}

				<button onClick={() => handleSaveBtn(field)}>
					update
				</button>
			</div>
		);
	}
;

export default UserDetail;
