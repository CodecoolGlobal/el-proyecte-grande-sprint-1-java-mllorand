import React, {useContext} from 'react';
import CoopDetailItem from "./CoopDetailItem";
import {ProfileContext} from "../../../context/ProfileContext";

const CooperatorSkills = () => {
	const {cooperatorData} = useContext(ProfileContext);

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Skills:</span>
				<button className="btn-add"><img src="/assets/plus.png" alt="add"/></button>
			</div>
			<div className="coop-detail-item-container">
				{cooperatorData.learnt.map(item => (
					<CoopDetailItem item={item} key={item.id}/>
				))}
			</div>
		</section>
	);
};

export default CooperatorSkills;
