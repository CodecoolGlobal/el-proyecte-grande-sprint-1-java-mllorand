import React, {useContext, useState} from 'react';
import {ProfileContext} from "../../../context/ProfileContext";
import Modal from "../Modal";
import CoopInterest from "./CoopInterest";
import {v4 as uuid} from "uuid";

const CooperatorInterests = ({handleAdd}) => {
	const {cooperatorData} = useContext(ProfileContext);
	const [showModal, setShowModal] = useState(false);
	const [currentInterests, setCurrentInterests] = useState(cooperatorData.interest)
	const [focusedInterest, setFocusedInterest] = useState(null)

	const handleShowModal = () => {
		setShowModal(true)
	}

	const handleCancel = () => {
		setShowModal(false)
		if (!focusedInterest.id) {
			let newCurrentInterests = [...currentInterests]
			newCurrentInterests.splice(-1)
			setCurrentInterests(newCurrentInterests)
		}
		setFocusedInterest(null)
	}

	const handleSave = () => {
		setShowModal(false)
		if (focusedInterest) {
			handleAdd(
				focusedInterest,
				'interest'
			)
		}
	}

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Interests:</span>

				{focusedInterest &&
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

				{!focusedInterest &&
					<button className="btn-add"
									onClick={handleShowModal}
					>
						<img src="/assets/plus.png" alt="add"/>
					</button>
				}
			</div>
			<div className="coop-detail-item-container">
				{currentInterests.map(interest => (
					<CoopInterest interest={interest} key={uuid()}
												focusedInterest={focusedInterest}
												setFocusedInterest={setFocusedInterest}
					/>))}
			</div>
			{
				showModal
				&&
				<Modal
					itemTemplate={{
						"id": null,
						"label": null,
						"interestPriority": null,
						"tags": []
					}}
					setShowModal={setShowModal}
					currentItems={currentInterests}
					setCurrentItems={setCurrentInterests}
					setFocusedItem={setFocusedInterest}
				/>
			}
		</section>
	);
};

export default CooperatorInterests;
