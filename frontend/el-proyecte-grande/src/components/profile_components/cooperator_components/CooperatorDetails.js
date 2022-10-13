import React from 'react';
import CooperatorSkills from "./CooperatorSkills";
import CooperatorInterests from "./CooperatorInterests";
import CooperatorDetail from "./CooperatorDetail";

const CooperatorDetails = ({cooperatorData, setCooperatorData, labels}) => {
	const {strengths, learnt, interested, learnFromScratch, improveIn} = cooperatorData;
	return (
		<>
			<CooperatorSkills
				detailItems={learnt}
				labels={labels}
			/>
			<CooperatorDetail
				fieldName='Strengths'
				detailItems={strengths}
				labels={labels}
			/>
			<CooperatorInterests
				detailItems={interested}
				labels={labels}
			/>
			<CooperatorDetail
				fieldName='Would like to start'
				detailItems={learnFromScratch}
				labels={labels}
			/>
			<CooperatorDetail
				fieldName='Would like to improve in'
				detailItems={improveIn}
				labels={labels}
			/>
		</>
	);
};

export default CooperatorDetails;
