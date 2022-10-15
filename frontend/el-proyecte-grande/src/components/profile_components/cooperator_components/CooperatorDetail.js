import React, {useContext, useState} from "react";
import Modal from "../Modal";
import {ProfileContext} from "../../../context/ProfileContext";

const CooperatorDetail = ({fieldName, handleAdd}) => {
	const [showModal, setShowModal] = useState(false);
	const {cooperatorData} = useContext(ProfileContext);


	const handleShowModal = () => {
		setShowModal(true)
	}

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>{fieldName}:</span>
				<button className="btn-add"
								onClick={() => handleShowModal()}
				>
					<img src="/assets/plus.png" alt="add"/>
				</button>
			</div>
			<div className="coop-detail-item-container">
				{cooperatorData[fieldName].map(item => (
					<div className="detail-item" key={item.id}>
						<img src={`/skill_icons/${item.internalName}.png`} alt={item.tooltipText}/>
					</div>
				))}
			</div>
			{
				showModal
				&&
				<Modal
					handleAdd={(label) => handleAdd(label, fieldName)}
				/>
			}
		</section>
	);
};

export default CooperatorDetail;
