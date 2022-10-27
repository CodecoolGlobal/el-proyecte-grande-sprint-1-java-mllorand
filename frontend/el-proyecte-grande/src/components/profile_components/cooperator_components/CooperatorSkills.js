import React, {useContext, useState} from 'react';
import CoopSkill from "./CoopSkill";
import {ProfileContext} from "../../../context/ProfileContext";
import Modal from "../Modal";

const CooperatorSkills = ({handleAdd}) => {
	const {cooperatorData} = useContext(ProfileContext);
	const [showModal, setShowModal] = useState(false);
	const [currentSkills, setCurrentSkills] = useState(cooperatorData.skills);
	const [skillsAreEdited, setSkillsAreEdited] = useState(false);
	const [editedSkills, setEditedSkills] = useState([]);
	const [addedSkills, setAddedSkills] = useState([]);

	const handleShowModal = () => {
		setShowModal(true)
	}

	const handleCancel = () => {
		let canceledSkillIds = [];
		canceledSkillIds.concat(editedSkills.map(skill => skill.id));
		canceledSkillIds.concat(addedSkills.map(skill => skill.id));
		setCurrentSkills(currentSkills.filter(skill => !(canceledSkillIds.includes(skill.label.id)))
		)
		setAddedSkills([]);
		setEditedSkills([]);
	}

	const handleSave = () => {
		editedSkills.forEach(skill => handleAdd(skill.label, 'skill', null, skill.skillQuantity, skill.skillUnit, 'patch'));
		addedSkills.forEach(skill => handleAdd(skill.label, 'skill', null, skill.skillQuantity, skill.skillUnit, 'post'));
	}

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Skills:</span>

				{skillsAreEdited &&
					<>
						<button className="btn-save"
										onClick={() => {
											setSkillsAreEdited(false);
											handleSave()
										}}
						>
							<img src="/assets/checkmark.png" alt="save"/>
						</button>

						<button className="btn-cancel"
										onClick={() => {
											setSkillsAreEdited(false);
											handleCancel();
										}}
						>
							<img src="/assets/cancel.png" alt="cancel"/>
						</button>
					</>

				}
				{!skillsAreEdited &&
					<button className="btn-add"
									onClick={() => {
										handleShowModal();
										setSkillsAreEdited(true)
									}}
					>
						<img src="/assets/plus.png" alt="add"/>
					</button>
				}

			</div>
			<div className="coop-detail-item-container">
				{currentSkills.map(skill => (
					<CoopSkill skill={skill} key={skill.id}
										 setSkillsAreEdited={setSkillsAreEdited}
										 currentSkills={currentSkills}
										 setCurrentSkills={setCurrentSkills}
										 editedSkills={editedSkills}
										 setEditedSkills={setEditedSkills}
					/>
				))}
			</div>
			{
				showModal
				&&
				<Modal
					fieldName='skills'
					currentItems={currentSkills}
					setCurrentItems={setCurrentSkills}
					addedItems={addedSkills}
					setAddedItems={setAddedSkills}
					itemTemplate={{
						"id": null,
						"label": null,
						"weightQuantity": 0,
						"weightUnit": "-"
					}}
				/>
			}
		</section>
	);
};

export default CooperatorSkills;
