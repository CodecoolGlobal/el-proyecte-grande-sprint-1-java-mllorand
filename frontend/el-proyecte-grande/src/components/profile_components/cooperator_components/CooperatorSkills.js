import React from 'react';
import CoopDetailItem from "./CoopDetailItem";

const CooperatorSkills = ({ detailItems, labels}) => {
	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Skills:</span>
				<button className="btn-add"><img src="/assets/plus.png" alt="add"/></button>
			</div>
			<div className="coop-detail-item-container">
				{detailItems.map(item => (
					<CoopDetailItem item={item} key={item.id}/>
				))}
			</div>
		</section>
	);
};

export default CooperatorSkills;
