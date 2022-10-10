import React from 'react';
import UserDetails from "./UserDetails";
import UserGroups from "./UserGroups";

const User = () => {
	return (
		<>
			<section id="profile-img">
				<img src="" alt=""/>
			</section>
			<UserDetails />
			<UserGroups />
		</>
	);
};

export default User;
