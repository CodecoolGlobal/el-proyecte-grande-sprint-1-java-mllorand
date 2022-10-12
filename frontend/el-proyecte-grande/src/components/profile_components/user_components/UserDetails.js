import React from 'react';
import UserDetail from "./UserDetail";

const UserDetails = ({userData, setUserData}) => {
	const {id, userName, emailAddress, fullName, age, gender} = userData;
	return (
		<section id="user-detail-container">

			<UserDetail
				id={id}
				fieldName='userName'
				fieldValue={userName.attributeValue}
				userData={userData}
				setUserData={setUserData}
			/>
			<UserDetail
				id={id}
				fieldName='fullName'
				fieldValue={fullName.attributeValue}
				userData={userData}
				setUserData={setUserData}
			/>
			<UserDetail
				id={id}
				fieldName='gender'
				fieldValue={gender.attributeValue}
				userData={userData}
				setUserData={setUserData}
			/>
			<UserDetail
				id={id}
				fieldName='age'
				fieldValue={`${age.attributeValue} years`}
				userData={userData}
				setUserData={setUserData}
			/>
			<UserDetail
				id={id}
				fieldName=''
				fieldValue={emailAddress.attributeValue}
				userData={userData}
				setUserData={setUserData}
			/>
		</section>
	);
};

export default UserDetails;
