import React from 'react';
import UserDetail from "./UserDetail";

const UserDetails = ({ user }) => {
	const { id, userName, emailAddress, fullName, age, gender } = user;
	return (
		<section id="user-detail-container">

			<UserDetail
				id={id}
				fieldName='Username'
				fieldValue={userName.attributeValue}/>
			<UserDetail
				id={id}
				fieldName='Full name'
				fieldValue={fullName.attributeValue}/>
			<UserDetail
				id={id}
				fieldName='Gender'
				fieldValue={gender.attributeValue}/>
			<UserDetail
				id={id}
				fieldName='Age'
				fieldValue={`${age.attributeValue} years`}/>
			<UserDetail
				id={id}
				fieldName='Email'
				fieldValue={emailAddress.attributeValue}/>
		</section>
	);
};

export default UserDetails;
