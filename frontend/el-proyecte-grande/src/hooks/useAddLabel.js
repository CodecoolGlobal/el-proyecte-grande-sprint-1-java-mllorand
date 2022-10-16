import axios from "axios";
const addLabel = (cooperatorData, setCooperatorData) => {
	return (
		(label, fieldName, prio, weightQuantity, weightUnit) => {
			let newCooperatorData = {...cooperatorData}
			if (prio) {
				const newInterestId = newCooperatorData[fieldName].id + 1
				const newInterest = {
					id: newInterestId,
					label: label,
					interestPriority: prio
				}
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], newInterest]
				axios.post(`/profile/${cooperatorData.id}/${fieldName}`, {
					"label": label,
					"interestPriority": prio
				})
				setCooperatorData(newCooperatorData);
			} else if (weightQuantity && weightQuantity) {
				const newLearntId = newCooperatorData[fieldName].id + 1
				const newLearnt = {
					id: newLearntId,
					label: label,
					weightQuantity: weightQuantity,
					weightUnit: weightUnit
				}
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], newLearnt]
				axios.post(`/profile/${cooperatorData.id}/${fieldName}`, {
					"label": label,
					"weightQuantity": weightQuantity,
					"weightUnit": weightUnit
				})
				setCooperatorData(newCooperatorData);
			} else {
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], label]
				axios.patch(`/profile/${cooperatorData.id}/${fieldName}`, {
					"id": label.id
				})
				setCooperatorData(newCooperatorData);
			}
		}
	)
}

export default addLabel;