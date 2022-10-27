import axios from "axios";

const useAddLabel = (cooperatorData, setCooperatorData) => {
	const requestConfig = {
		headers:
			{
				Authorization: localStorage.getItem('access_token')
			}
	};
	return (
		(label, fieldName, prio, tags, weightQuantity, weightUnit, requestType) => {
			let newCooperatorData = {...cooperatorData}
			if (prio && tags) {
				const newInterestId = parseInt(newCooperatorData[fieldName].id) + 1
				const newInterest = {
					id: newInterestId,
					label: label,
					interestPriority: prio,
					tags: tags
				}
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], newInterest]
				const data = {
					"label": label,
					"interestPriority": prio,
					"tags": tags
				};
				if (requestType === 'post') axios.post(`/cooperator/${fieldName}`, data, requestConfig)
				else axios.patch(`/cooperator/${fieldName}`, data, requestConfig)
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
				if (requestType === 'post') axios.post(`/cooperator/${fieldName}`, data, requestConfig)
				else axios.patch(`/cooperator/${fieldName}`, data, requestConfig)
				setCooperatorData(newCooperatorData);

			} else {
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], label]
				axios.post(`/cooperator/${fieldName}`, {
					"id": label.id,
					"internalName": label.internalName,
					"toolTipText": label.toolTipText
				}, requestConfig)
				setCooperatorData(newCooperatorData);
			}
		}
	)
}

export default useAddLabel;