import React, {useContext, useEffect, useState} from 'react';
import User from "./user_components/User";
import Cooperator from "./cooperator_components/Cooperator";
import {ProfileContext} from "../../context/ProfileContext";
import {useNavigate} from "react-router-dom";
import axios from "axios";

const Profile = () => {
	const {userData, setUserData} = useContext(ProfileContext);
	const {cooperatorData, setCooperatorData} = useContext(ProfileContext);
	const {labels, setLabels} = useContext(ProfileContext);
	const authToken = localStorage.getItem("access_token");
	const [profile, setProfile] = useState(null);
	const navigate = useNavigate();
	// const [cooperator, setCooperator] = useState(null);


	useEffect(() => {
		axios.get("/api/cooperator/1", {
			headers: {
				'Authorization': 'Bearer ' + authToken
			}
		}).then((res) => setProfile(res.data));

		axios.get("/api/label/labels", {
			headers: {
				'Authorization': 'Bearer ' + authToken
			}
		}).then((res) => setLabels(res.data));

	}, []);

	useEffect(() => {
		if (!authToken) navigate('/login');
	}, [authToken])

	useEffect(() => {
		// console.log(profile)
			if (profile) {
				setUserData({
					id: profile.id,
					name: profile.name,
					emailAddress: profile.emailAddress,
					fullName: profile.fullName,
					age: profile.age,
					gender: profile.gender
				});
				setCooperatorData({
					id: profile.id,
					strength: profile.strengths,
					skill: profile.skills,
					interest: profile.interests,
					learnFromScratch: profile.learnFromScratch,
					improveIn: profile.improveIn
				});
				// setCooperator({...userData,...cooperatorData});
			}
		}, [profile]
	)

	// useEffect(() => {
	// 	setCooperator({...userData,...cooperatorData});
	// 	return () => {
	// 		console.log("component did unmount")
	// 	};
	// }, [cooperatorData]);





	if (!authToken) return 'loading..';

	if (!(
		userData &&
		cooperatorData &&
		labels)) {
		return (
			<div>
				loading...
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
