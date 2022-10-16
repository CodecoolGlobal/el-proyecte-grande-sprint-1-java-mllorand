import React from 'react';

const CoopDetailItem = ({ item }) => {
	return (
		<div className="detail-item">
			<img src={`/skill_icons/${item.label.internalName}.png`} alt={item.label.tooltipText} />
			<div className='exp-container'>
				<input className='weight-quantity' value={item.weightQuantity}></input>
				<input className='weight-unit' value={item.weightUnit}></input>
			</div>
		</div>
	);
};

export default CoopDetailItem;
