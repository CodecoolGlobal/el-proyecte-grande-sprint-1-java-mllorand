import React from 'react';

const CooperatorDetail = ({ fieldName, detailItems }) => {
	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>{fieldName}</span>
				<button className="btn-add"><img src="" alt=""/></button>
			</div>
			<div className="coop-detail-item-container">
				{detailItems.map(item => (
					<div className="detail-item" key={item.id}>
						<img src={`/skill_icons/${item.internalName}.png`} alt={item.displayName}/>
					</div>
				))}
			</div>
		</section>
	);
};

export default CooperatorDetail;
