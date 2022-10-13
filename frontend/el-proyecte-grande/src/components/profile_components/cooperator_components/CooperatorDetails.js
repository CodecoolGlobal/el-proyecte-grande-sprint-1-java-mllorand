import React from 'react';
import CooperatorSkills from "./CooperatorSkills";
import CooperatorInterests from "./CooperatorInterests";
import CooperatorDetail from "./CooperatorDetail";

const CooperatorDetails = ({ cooperatorData, setCooperatorData }) => {
	const {strengths, learnt, interested, learnFromScratch, improveIn } = cooperatorData;
	return (
		<>
				<CooperatorSkills detailItems={learnt}/>
				<CooperatorDetail fieldName='Strengths' detailItems={strengths}/>
				<CooperatorInterests detailItems={interested}/>
				<CooperatorDetail fieldName='Would like to start' detailItems={learnFromScratch}/>
				<CooperatorDetail fieldName='Would like to improve in' detailItems={improveIn}/>
		</>
	);
};

export default CooperatorDetails;
