import UserDetail from "./UserDetail";

const UserDetails = () => {
	return (
		<section id="user-detail-container">
			<UserDetail
				fieldName='name'
			/>
			<UserDetail
				fieldName='fullName'
			/>
			<UserDetail
				fieldName='gender'
			/>
			<UserDetail
				fieldName='age'
			/>
			<UserDetail
				fieldName='emailAddress'
			/>
		</section>
	);
};

export default UserDetails;
