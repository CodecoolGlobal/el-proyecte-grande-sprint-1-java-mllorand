import React, {useContext, useState, useEffect} from 'react';
import CoopSkill from "./CoopSkill";
import {ProfileContext} from "../../../context/ProfileContext";
import Modal from "../Modal";
import {v4 as uuid} from 'uuid';

const CooperatorSkills = ({handleAdd}) => {
	const {cooperatorData} = useContext(ProfileContext);
	const [showModal, setShowModal] = useState(false);
	const [currentSkills, setCurrentSkills] = useState(cooperatorData.skill);
	const [skillsAreEdited, setSkillsAreEdited] = useState(false);
	const [editedSkills, setEditedSkills] = useState([]);
	const [addedSkills, setAddedSkills] = useState([]);

	// console.log(cooperatorData)

	useEffect(() => {
		console.log("current skills: ", currentSkills)
	}, [currentSkills])


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
		// console.log('added: ', addedSkills)
		// editedSkills.forEach(skill => handleAdd(skill.label, 'skills', null, null, skill.skillQuantity, skill.skillUnit, 'patch'));
		addedSkills.forEach(skill => {
			console.log(skill)
			handleAdd(skill.label, 'skill', null, null, skill.skillQuantity, skill.skillUnit, 'post')
		});
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
											setShowModal(false)
										}}
						>
							<img src="/assets/checkmark.png" alt="save"/>
						</button>

						<button className="btn-cancel"
										onClick={() => {
											setSkillsAreEdited(false);
											handleCancel();
											setShowModal(false)
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
				{currentSkills.map(skill => {
					return (
					<CoopSkill skill={skill} key={uuid()}
										 setSkillsAreEdited={setSkillsAreEdited}
										 currentSkills={currentSkills}
										 setCurrentSkills={setCurrentSkills}
										 editedSkills={editedSkills}
										 setEditedSkills={setEditedSkills}
										 addedSkills={addedSkills}
										 setAddedSkills={setAddedSkills}
					/>)}
				)}
			</div>
			{
				showModal
				&&
				<Modal
					currentItems={currentSkills}
					setCurrentItems={setCurrentSkills}
					addedItems={addedSkills}
					setAddedItems={setAddedSkills}
					itemTemplate={{
						"id": uuid(),
						"label": null,
						"skillQuantity": 0,
						"skillUnit": "-"
					}}
				/>
			}
		</section>
	);
};

export default CooperatorSkills;
