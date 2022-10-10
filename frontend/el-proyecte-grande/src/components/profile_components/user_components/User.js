import React from 'react';
import UserDetails from "./UserDetails";
import UserGroups from "./UserGroups";

const User = ({ user }) => {
	return (
		<>
			<section id="profile-img">
				<img src="/assets/logo.png" alt="profile pic"/>
			</section>
			<UserDetails user={user}/>
			<UserGroups />
		</>
	);
};

export default User;
