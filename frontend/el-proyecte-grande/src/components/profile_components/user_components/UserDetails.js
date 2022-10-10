import React from 'react';
import UserDetail from "./UserDetail";

const UserDetails = () => {
	return (
		<section id="user-detail-container">

			<UserDetail fieldName='Username'
									fieldValue='Sanyika'/>
			<UserDetail fieldName='Full name'
									fieldValue='Kovács Sándor'/>
			<UserDetail fieldName='Gender'
									fieldValue='Male'/>
			<UserDetail fieldName='Age'
									fieldValue='27 yrs'/>
			<UserDetail fieldName='Address'
									fieldValue='Dob utca 1'/>
		</section>
	);
};

export default UserDetails;
