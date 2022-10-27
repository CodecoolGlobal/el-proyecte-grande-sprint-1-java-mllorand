import axios from "axios";
const addLabel = (cooperatorData, setCooperatorData) => {
	return (
		(label, fieldName, prio, weightQuantity, weightUnit, requestType) => {
			let newCooperatorData = {...cooperatorData}
			if (prio) {
				const newInterestId = parseInt(newCooperatorData[fieldName].id) + 1
				const newInterest = {
					id: newInterestId,
					label: label,
					interestPriority: prio
				}
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], newInterest]
				const data = {
					"label": label,
					"interestPriority": prio
				};
				if (requestType === 'post') axios.post(`/cooperator/${fieldName}`, data)
				else axios.patch(`/cooperator/${fieldName}`, data)
				setCooperatorData(newCooperatorData);

			} else if (weightQuantity && weightQuantity) {
				const newLearntId = parseInt(newCooperatorData[fieldName].id) + 1
				const newLearnt = {
					id: newLearntId,
					label: label,
					weightQuantity: weightQuantity,
					weightUnit: weightUnit
				}
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], newLearnt]
				const data = {
					"label": label,
					"weightQuantity": weightQuantity,
					"weightUnit": weightUnit
				};
				if (requestType === 'post') axios.post(`/cooperator/${fieldName}`, data)
				else axios.patch(`/cooperator/${fieldName}`, data)
				setCooperatorData(newCooperatorData);

			} else {
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], label]
				axios.post(`/cooperator/${fieldName}`, {
					"id": label.id,
					"internalName": label.internalName,
					"toolTipText": label.toolTipText
				})
				setCooperatorData(newCooperatorData);
			}
		}
	)
}

export default addLabel;