import axios from "axios";

const useAddLabel = (cooperatorData, setCooperatorData) => {
	const requestConfig = {
		headers:
			{
				Authorization: 'Bearer ' + localStorage.getItem('access_token')
			}
	};
	return (
		(label, fieldName, prio, tags, skillQuantity, skillUnit, requestType) => {
			let newCooperatorData = {...cooperatorData}
			if (prio && tags) {
				const newInterest = {
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
				if (requestType === 'post') axios.post(`/api/cooperator/${fieldName}`, data, requestConfig)
				else axios.patch(`/api/cooperator/${fieldName}`, data, requestConfig)
				setCooperatorData(newCooperatorData);

			} else if (skillQuantity && skillUnit) {
				const newLearnt = {
					id: null,
					label: label,
					skillQuantity: skillQuantity,
					skillUnit: skillUnit
				}
				console.log(cooperatorData)
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], newLearnt]
				const data = {
					'id': null,
					"label": label,
					"skillQuantity": skillQuantity,
					"skillUnit": skillUnit
				};
				if (requestType === 'post') axios.post(`/api/cooperator/${fieldName}`, data, requestConfig)
				else axios.patch(`/api/cooperator/${fieldName}`, data, requestConfig)
				setCooperatorData(newCooperatorData);

			} else {
				console.log(newCooperatorData)
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], label]
				axios.post(`/api/cooperator/${fieldName}`, {
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