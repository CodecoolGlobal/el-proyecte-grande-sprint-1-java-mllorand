import React, {useContext, useState} from 'react';
import CoopDetailItem from "./CoopDetailItem";
import {ProfileContext} from "../../../context/ProfileContext";
import Modal from "../Modal";

const CooperatorSkills = ({handleAdd}) => {
	const {cooperatorData} = useContext(ProfileContext);
	const [showModal, setShowModal] = useState(false);

	const handleShowModal = () => {
		setShowModal(true)
	}

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Skills:</span>
				<button className="btn-add"
								onClick={() => handleShowModal()}
				>
					<img src="/assets/plus.png" alt="add"/>
				</button>
			</div>
			<div className="coop-detail-item-container">
				{cooperatorData.skills.map(item => (
					<CoopDetailItem item={item} key={item.id}/>
				))}
			</div>
			{
				showModal
				&&
				<Modal
					fieldName='skills'
					handleAdd={(label, weightQuantity, weightUnit) => handleAdd(label, 'learnt', null, weightQuantity, weightUnit)}
				/>
			}
		</section>
	);
};

export default CooperatorSkills;
