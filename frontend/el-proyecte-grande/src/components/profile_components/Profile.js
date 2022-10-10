import React, {useState} from 'react';
import User from "./user_components/User";
import CooperatorDetails from "./cooperator_components/CooperatorDetails";

const profileData = {
	"id": 1,
	"userName": {
		"id": 0,
		"attributeValue": "anthony2",
		"visibility": "PUBLIC"
	},
	"emailAddress": {
		"id": 0,
		"attributeValue": "anthony2@gmail.com",
		"visibility": "GROUPS_ONLY"
	},
	"fullName": {
		"id": 0,
		"attributeValue": "Anthony Miller",
		"visibility": "PUBLIC"
	},
	"age": {
		"id": 0,
		"attributeValue": 35,
		"visibility": "PRIVATE"
	},
	"gender": {
		"id": 0,
		"attributeValue": "MALE",
		"visibility": "PUBLIC"
	},
	"strengths": [
		{
			"id": 1,
			"internalName": "js",
			"toolTipText": "javascript"
		}
	],
	"learnt": [
		{
			"id": 5,
			"internalName": "react",
			"toolTipText": "React",
			"weightQuantity": 3,
			"weightUnit": "month"
		}
	],
	"interested": [
		{
			"id": 2,
			"internalName": "java",
			"toolTipText": "java",
			"interestPriority": "Primary"
		}
	],
	"learnFromScratch": [
		{
			"id": 4,
			"internalName": "docker",
			"toolTipText": "Docker"
		}
	],
	"improveIn": [
		{
			"id": 3,
			"internalName": "react",
			"toolTipText": "React"
		}
	]
}

const Profile = () => {
	const [profile, setProfile] = useState(profileData);
	const [userData, setUserData] = useState({
		id: profile.id,
		userName: profile.userName,
		emailAddress: profile.emailAddress,
		fullName: profile.fullName,
		age: profile.age,
		gender: profile.gender
	});
	const [cooperatorData, setCooperatorData] = useState({
		id: profile.id,
		strengths: profile.strengths,
		learnt: profile.learnt,
		interested: profile.interested,
		learnFromScratch: profile.learnFromScratch,
		improveIn: profile.improveIn
	});

	return (
		<article id="profile-content">
			<aside id="user-details-content">
				<User user={userData}/>
			</aside>
			<main id="cooperator-details-content">
				<CooperatorDetails cooperator={cooperatorData}/>
			</main>
		</article>
	);
};

export default Profile;
