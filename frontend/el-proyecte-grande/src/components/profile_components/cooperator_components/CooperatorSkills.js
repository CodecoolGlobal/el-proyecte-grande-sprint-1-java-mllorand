import React, {useContext, useState, useEffect} from 'react';
import CoopSkill from "./CoopSkill";
import {ProfileContext} from "../../../context/ProfileContext";
import Modal from "../Modal";
import {v4 as uuid} from 'uuid';

const CooperatorSkills = ({handleAdd}) => {
	const {cooperatorData} = useContext(ProfileContext);
	const [showModal, setShowModal] = useState(false);
	const [skillsAreEdited, setSkillsAreEdited] = useState(false);
	const [currentSkills, setCurrentSkills] = useState(cooperatorData.skill)
	const [focusedSkill, setFocusedSkill] = useState(null)

	const handleShowModal = () => {
		setShowModal(true)
	}

	const handleCancel = () => {
		setShowModal(false)
		skillsAreEdited(false)
		if (!focusedSkill.id) {
			let newCurrentSkills = [...currentSkills]
			newCurrentSkills.splice(-1)
			setCurrentSkills(newCurrentSkills)
		}
		setFocusedSkill(null)
	}

	const handleSave = () => {
		setShowModal(false)
		skillsAreEdited(false)
		if (focusedSkill) {
			handleAdd(
				focusedSkill,
				'skill'
			)
		}
	}

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Skills:</span>
				{skillsAreEdited &&
					<>
						<button className="btn-save"
										onClick={handleSave}
						>
							<img src="/assets/checkmark.png" alt="save"/>
						</button>

						<button className="btn-cancel"
										onClick={handleCancel}

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

					/>)}
				)}
			</div>
			{
				showModal
				&&
				<Modal
					itemTemplate={{
						"id": null,
						"label": null,
						"skillQuantity": 0,
						"skillUnit": "-"
					}}
					setShowModal={setShowModal}
					currentSkills = {currentSkills}
					setCurrentSkills = {setCurrentSkills}
					setFocusedSkill = {setFocusedSkill}
				/>
			}
		</section>
	);
};

export default CooperatorSkills;
