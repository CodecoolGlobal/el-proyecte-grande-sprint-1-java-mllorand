import React from 'react';

const UserDetail = ({ id, fieldName, fieldValue }) => {
	return (
		<div className="usr-detail">
			<span className='field-label'>{fieldName}:</span>
			<span className='field'>{fieldValue}</span>
		</div>
	);
};

export default UserDetail;
