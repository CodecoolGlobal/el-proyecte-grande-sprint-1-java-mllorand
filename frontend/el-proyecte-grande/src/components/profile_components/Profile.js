import React, {useEffect, useState} from 'react';
import User from "./user_components/User";
import CooperatorDetails from "./cooperator_components/CooperatorDetails";
import useAxios from "../../hooks/useAxios";
import axios from '../../apis/profileData'

const Profile = () => {
	const [userData, setUserData] = useState(null);
	const [cooperatorData, setCooperatorData] = useState(null);

	const [profile, error, loading] = useAxios({
		axiosInstance: axios,
		method: 'GET',
		url: '/2'
	});

	useEffect(() => {
			if (!loading && !error) {
				setUserData({
					id: profile.id,
					userName: profile.userName,
					emailAddress: profile.emailAddress,
					fullName: profile.fullName,
					age: profile.age,
					gender: profile.gender
				});
				setCooperatorData({
					id: profile.id,
					strengths: profile.strengths,
					learnt: profile.learnt,
					interested: profile.interested,
					learnFromScratch: profile.learnFromScratch,
					improveIn: profile.improveIn
				})
			}
		}, [error, loading]
	)


	return (
		<>
			{loading && <p>Loading...</p>}
			{!loading && error && <p>{error}</p>}
			{!loading && !error && userData && cooperatorData &&
				<article id="profile-content">
					<aside id="user-details-content">
						<User
							userData={userData}
							setUserData={setUserData}
						/>
					</aside>
					<main id="cooperator-details-content">
						<CooperatorDetails
							cooperator={cooperatorData}
							setCooperator={setCooperatorData}
						/>
					</main>
				</article>}
			{!loading && !error && !profile && <p>No profile data</p>}
		</>
	);
};

export default Profile;
