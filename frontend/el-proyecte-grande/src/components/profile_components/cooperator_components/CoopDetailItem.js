import React from 'react';

const CoopDetailItem = ({ item }) => {
	return (
		<div className="detail-item">
			<img src={`/skill_icons/${item.internalName}.png`} alt={item.tooltipText} />
			<div className='exp-container'>
				<p>{item.weightQuantity}</p>
				<p>{item.weightUnit}</p>
			</div>
		</div>
	);
};

export default CoopDetailItem;
