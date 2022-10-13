import React from 'react';
import UserDetails from "./UserDetails";
import UserGroups from "./UserGroups";

const User = ({userData, setUserData}) => {
	return (
		<>
			<section id="profile-img">
				<img src="/assets/lori.png" alt="profile pic"/>
			</section>
			<UserDetails
				userData={userData}
				setUserData={setUserData}
			/>
			<UserGroups/>
		</>
	);
};

export default User;
