import CooperatorSkills from "./CooperatorSkills";
import CooperatorInterests from "./CooperatorInterests";
import CooperatorDetail from "./CooperatorDetail";
import axios from "axios";
import {useContext} from "react";
import {ProfileContext} from "../../../context/ProfileContext";

const CooperatorDetails = () => {
	const {cooperatorData, setCooperatorData} = useContext(ProfileContext);

	const handleAddLabel = (label, fieldName) => {
		let newCooperatorData = {...cooperatorData}
		newCooperatorData[fieldName] = [...newCooperatorData[fieldName], label]
		axios.patch(`/profile/${cooperatorData.id}/${fieldName}`, {
			"id": label.id
		})
		setCooperatorData(newCooperatorData);
	}

	return (
		<>

			<CooperatorSkills/>

			<CooperatorDetail
				fieldName='strengths'
				handleAdd={handleAddLabel}
			/>

			<CooperatorInterests/>

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
