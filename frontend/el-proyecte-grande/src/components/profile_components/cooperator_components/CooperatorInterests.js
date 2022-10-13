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
						<img src={`/skill_icons/${item.label.internalName}.png`} alt={item.label.tooltipText}/>
						<select name="prio" value={item.interestPriority} id="prio">
							<option value="Primary">Primary</option>
							<option value="Secondary">Secondary</option>
							<option value="Tertiary">Tertiary</option>
						</select>
					</div>
				))}
			</div>
		</section>
	);
};

export default CooperatorInterests;
