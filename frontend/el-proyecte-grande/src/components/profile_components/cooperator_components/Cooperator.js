import CooperatorSkills from "./CooperatorSkills";
import CooperatorInterests from "./CooperatorInterests";
import CooperatorDetails from "./CooperatorDetails";
import {useContext} from "react";
import {ProfileContext} from "../../../context/ProfileContext";
import useAddLabel from "../../../hooks/useAddLabel";

const Cooperator = () => {
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

			<CooperatorDetails
				fieldName='strengths'
				handleAdd={handleAddLabel}
			/>

			<CooperatorDetails
				fieldName='learnFromScratch'
				handleAdd={handleAddLabel}
			/>

			<CooperatorDetails
				fieldName='improveIn'
				handleAdd={handleAddLabel}
			/>
		</>
	);
};

export default Cooperator;
