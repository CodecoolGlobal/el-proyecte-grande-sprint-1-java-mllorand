import React from 'react';
import User from "./user_components/User";
import CooperatorDetails from "./cooperator_components/CooperatorDetails";

const Profile = () => {

	return (
		<article id="profile-content">
			<aside id="user-details-content">
				<User />
			</aside>
			<main id="cooperator-details-content">
				<CooperatorDetails />
			</main>
		</article>
	);
};

export default Profile;
