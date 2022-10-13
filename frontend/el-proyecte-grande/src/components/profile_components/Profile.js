import React, {useEffect, useState} from 'react';
import User from "./user_components/User";
import CooperatorDetails from "./cooperator_components/CooperatorDetails";
import useAxios from "../../hooks/useAxios";
import profileAxios from '../../apis/profileData'
import affinityAxios from '../../apis/affinityLabels'
import {CooperatorContextProvider} from "../../context/CooperatorContext";

const Profile = () => {
	const [userData, setUserData] = useState(null);
	const [cooperatorData, setCooperatorData] = useState(null);

	const [profile, profileError, profileLoading] = useAxios({
		axiosInstance: profileAxios,
		method: 'GET',
		url: '/1'
	});

	const [labels, labelsError, labelsLoading] = useAxios({
		axiosInstance: affinityAxios,
		method: 'GET',
		url: '/all'
	});


	useEffect(() => {
			if (!profileLoading && !profileError) {
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
		}, [profileError, profileLoading]
	)


	return (
		<>
			{profileLoading && <p>Loading...</p>}
			{labelsLoading && <p>Loading...</p>}
			{!profileLoading && profileError && <p>{profileError}</p>}
			{!labelsLoading && labelsError && <p>{labelsError}</p>}
			{!profileLoading &&
				!profileError &&
				!labelsLoading &&
				!labelsError &&
				userData &&
				cooperatorData &&
				labels
				&&
				<article id="profile-content">
					<aside id="user-details-content">
						<User
							userData={userData}
							setUserData={setUserData}
						/>
					</aside>
					<main id="cooperator-details-content">
						<CooperatorContextProvider>
							<CooperatorDetails
								cooperatorData={cooperatorData}
								setCooperatorData={setCooperatorData}
								labels={labels}
							/>
						</CooperatorContextProvider>
					</main>
				</article>}
			{!profileLoading && !profileError && !profile && <p>No profile data</p>}
			{!labelsLoading && !labelsError && !labels && <p>No label data</p>}
		</>
	);
};

export default Profile;
