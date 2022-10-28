import axios from "axios";

const useAddLabel = (cooperatorData, setCooperatorData) => {
	const requestConfig = {
		headers:
			{
				Authorization: 'Bearer ' + localStorage.getItem('access_token')
			}
	};
	return (
		(updatedEntity, fieldName) => {
			let newCooperatorData = {...cooperatorData}
			if (updatedEntity.id) {
				axios.post(`/api/cooperator/${fieldName}`, updatedEntity, requestConfig)
				newCooperatorData[fieldName] = [...newCooperatorData[fieldName], updatedEntity]
			} else {
				axios.patch(`/api/cooperator/${fieldName}`, updatedEntity, requestConfig)
				newCooperatorData[fieldName] = newCooperatorData[fieldName].map(skill => (
					skill.id === updatedEntity.id ? updatedEntity : skill
				))
			}
			setCooperatorData(newCooperatorData)
		})
}

export default useAddLabel;