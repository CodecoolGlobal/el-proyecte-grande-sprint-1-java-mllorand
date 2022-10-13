import React from 'react';

const CooperatorInterests = ({ detailItems, labels }) => {
	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Interests:</span>
				<button className="btn-add"><img src="" alt=""/></button>
			</div>
			<div className="coop-detail-item-container">
				{detailItems.map(item => (
					<div className="detail-item" key={item.id}>
						<img src={`/skill_icons/${item.internalName}.png`} alt={item.tooltipText}/>
						<select name="prio" value={item.interestPriority} id="prio">
							<option value="">First</option>
							<option value="">Second</option>
							<option value="">Third</option>
						</select>
					</div>
				))}
			</div>
		</section>
	);
};

export default CooperatorInterests;
