import React from 'react';

const TechLabel = ({label}) => {
	console.log("label in techlabel:", label)
	return (
		<div className="detail-item">
			<img src={`/tech_icons/${label.internalName}.png`} alt={label.tooltipText}/>
		</div>
	);
};

export default TechLabel;
