import React, {useContext, useState} from 'react';
import CoopSkill from "./CoopSkill";
import {ProfileContext} from "../../../context/ProfileContext";
import Modal from "../Modal";
import {v4 as uuid} from 'uuid';

const CooperatorSkills = ({handleAdd}) => {
	const {cooperatorData} = useContext(ProfileContext);
	const [showModal, setShowModal] = useState(false);
	const [currentSkills, setCurrentSkills] = useState(cooperatorData.skill)
	const [focusedSkill, setFocusedSkill] = useState(null)

	const handleShowModal = () => {
		setShowModal(true)
	}

	const handleCancel = () => {
		setShowModal(false)
		if (!focusedSkill.id) {
			let newCurrentSkills = [...currentSkills]
			newCurrentSkills.splice(-1)
			setCurrentSkills(newCurrentSkills)
		}
		setFocusedSkill(null)
	}

	const handleSave = () => {
		setShowModal(false)
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
				{focusedSkill &&
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

				{!focusedSkill &&
					<button className="btn-add"
									onClick={handleShowModal}
					>
						<img src="/assets/plus.png" alt="add"/>
					</button>
				}
			</div>
			<div className="coop-detail-item-container">
				{currentSkills.map(skill => (
					<CoopSkill skill={skill} key={uuid()}
										 focusedSkill={focusedSkill}
										 setFocusedSkill={setFocusedSkill}

					/>))}
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
					currentItems = {currentSkills}
					setCurrentItems = {setCurrentSkills}
					setFocusedItem = {setFocusedSkill}
				/>
			}
		</section>
	);
};

export default CooperatorSkills;
