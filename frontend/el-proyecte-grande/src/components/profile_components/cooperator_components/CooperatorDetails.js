import CooperatorSkills from "./CooperatorSkills";
import CooperatorInterests from "./CooperatorInterests";
import CooperatorDetail from "./CooperatorDetail";
import {useContext} from "react";
import {ProfileContext} from "../../../context/ProfileContext";
import useAddLabel from "../../../hooks/useAddLabel";

const CooperatorDetails = () => {
	const {cooperatorData, setCooperatorData} = useContext(ProfileContext);
	const handleAddLabel = useAddLabel(cooperatorData, setCooperatorData);
	return (
		<>
			<CooperatorSkills
				handleAdd={handleAddLabel}
			/>

			<CooperatorInterests
				handleAdd={handleAddLabel}
			/>

			<CooperatorDetail
				fieldName='strengths'
				handleAdd={handleAddLabel}
			/>

			<CooperatorDetail
				fieldName='learnFromScratch'
				handleAdd={handleAddLabel}
			/>

			<CooperatorDetail
				fieldName='improveIn'
				handleAdd={handleAddLabel}
			/>
		</>
	);
};

export default CooperatorDetails;
