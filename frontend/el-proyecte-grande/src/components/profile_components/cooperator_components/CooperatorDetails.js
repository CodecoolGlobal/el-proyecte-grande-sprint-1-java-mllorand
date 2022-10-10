import React from 'react';
import CooperatorSkills from "./CooperatorSkills";
import CooperatorInterests from "./CooperatorInterests";
import CooperatorDetail from "./CooperatorDetail";

const CooperatorDetails = ({ cooperator }) => {
	return (
		<>
				<CooperatorSkills detailItems={cooperator.learnt}/>
				<CooperatorDetail fieldName='Strengths' detailItems={cooperator.strengths}/>
				<CooperatorInterests detailItems={cooperator.interested}/>
				<CooperatorDetail fieldName='Would like to start' detailItems={cooperator.learnFromScratch}/>
				<CooperatorDetail fieldName='Would like to improve in' detailItems={cooperator.improveIn}/>
		</>
	);
};

export default CooperatorDetails;
