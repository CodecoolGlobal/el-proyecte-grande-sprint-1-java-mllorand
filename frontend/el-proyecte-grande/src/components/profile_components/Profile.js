import React, {useContext, useEffect} from 'react';
import User from "./user_components/User";
import Cooperator from "./cooperator_components/Cooperator";
import useAxios from "../../hooks/useAxios";
import profileAxios from '../../apis/profileData'
import affinityAxios from '../../apis/affinityLabels'
import {ProfileContext} from "../../context/ProfileContext";

const Profile = () => {
	const {userData, setUserData} = useContext(ProfileContext);
	const {cooperatorData, setCooperatorData} = useContext(ProfileContext);
	const {setLabels} = useContext(ProfileContext);


	const [profile, profileError, profileLoading] = useAxios({
		axiosInstance: profileAxios(),
		method: 'GET',
		url: '/1',
	});

	const [labels, labelsError, labelsLoading] = useAxios({
		axiosInstance: affinityAxios(),
		method: 'GET',
		url: '/all'
	});


	useEffect(() => {
			if (!profileLoading && !profileError && !labelsLoading && !labelsError) {
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
				});
				setLabels(labels);
			}
		}, [profileError, profileLoading, labelsError, labelsLoading]
	)

	if (!(
		!profileLoading &&
		!profileError &&
		!labelsLoading &&
		!labelsError &&
		userData &&
		cooperatorData &&
		labels)) {
		return (
			<div>
				{(profileLoading || labelsLoading) && <p>Loading...</p>}
				{!profileLoading && profileError && <p>{profileError}</p>}
				{!labelsLoading && labelsError && <p>{labelsError}</p>}
			</div>
		)
	}

	return (
				<article id="profile-content">
					<aside id="user-details-content">
						<User/>
					</aside>
					<main id="cooperator-details-content">
						<Cooperator/>
					</main>
				</article>
	);
};

export default Profile;
