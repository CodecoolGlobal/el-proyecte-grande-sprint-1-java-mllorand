import React, {useContext, useState} from 'react';
import {ProfileContext} from "../../../context/ProfileContext";
import Modal from "../Modal";

const CooperatorInterests = ({handleAdd}) => {
	const {cooperatorData} = useContext(ProfileContext);
	const [showModal, setShowModal] = useState(false);

	const handleShowModal = () => {
		setShowModal(true)
	}

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Interests:</span>
				<button className="btn-add"
								onClick={() => handleShowModal()}
				>
					<img src="/assets/plus.png" alt="add"/>
				</button>
			</div>
			<div className="coop-detail-item-container">
				{cooperatorData.interested.map(item => (
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
			{
				showModal
				&&
				<Modal
					fieldName='interests'
					handleAdd={(label, prio) => handleAdd(label, 'interested', prio, null, null)}
				/>
			}
		</section>
	);
};

export default CooperatorInterests;
