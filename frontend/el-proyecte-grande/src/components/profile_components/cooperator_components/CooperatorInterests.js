import React, {useContext, useState} from 'react';
import {ProfileContext} from "../../../context/ProfileContext";
import Modal from "../Modal";
import CoopInterest from "./CoopInterest";

const CooperatorInterests = ({handleAdd}) => {
	const {cooperatorData} = useContext(ProfileContext);
	const [showModal, setShowModal] = useState(false);
	const [currentInterests, setCurrentInterests] = useState(cooperatorData.interests);
	const [interestsAreEdited, setInterestsAreEdited] = useState(false);
	const [editedInterests, setEditedInterests] = useState([]);
	const [addedInterests, setAddedInterests] = useState([]);

	const handleShowModal = () => {
		setShowModal(true)
	}

	const handleCancel = () => {
		let canceledInterestIds = [];
		canceledInterestIds.concat(editedInterests.map(interest => interest.id));
		canceledInterestIds.concat(addedInterests.map(interest => interest.id));
		setCurrentInterests(currentInterests.filter(interest => !(canceledInterestIds.includes(interest.label.id)))
		)
		setAddedInterests([]);
		setEditedInterests([]);
	}

	const handleSave = () => {
		editedInterests.forEach(interest => handleAdd(interest.label, 'interest', interest.interestPriority, interest.tags, null, null, 'patch'));
		addedInterests.forEach(interest => handleAdd(interest.label, 'interest', interest.interestPriority, interest.tags, null, null, 'post'));
	}

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>Interests:</span>

				{interestsAreEdited &&
					<>
						<button className="btn-save"
										onClick={() => {
											setInterestsAreEdited(false);
											handleSave()
										}}
						>
							<img src="/assets/checkmark.png" alt="save"/>
						</button>

						<button className="btn-cancel"
										onClick={() => {
											setInterestsAreEdited(false);
											handleCancel();
										}}
						>
							<img src="/assets/cancel.png" alt="cancel"/>
						</button>
					</>
				}
				
				{!interestsAreEdited &&
					<button className="btn-add"
									onClick={() => {
										handleShowModal();
										setInterestsAreEdited(true)
									}}
					>
						<img src="/assets/plus.png" alt="add"/>
					</button>
				}
			</div>

			<div className="coop-detail-item-container">
				{currentInterests.map(interest => (
					<CoopInterest interest={interest} key={interest.id}
										 setInterestsAreEdited={setInterestsAreEdited}
										 currentInterests={currentInterests}
										 setCurrentInterests={setCurrentInterests}
										 editedInterests={editedInterests}
										 setEditedInterests={setEditedInterests}
					/>
				))}
			</div>

			{
				showModal
				&&
				<Modal
					fieldName='interests'
					currentItems={currentInterests}
					setCurrentItems={setCurrentInterests}
					addedItems={addedInterests}
					setAddedItems={setAddedInterests}
					itemTemplate={{
						"id": null,
						"label": null,
						"interestPriority": null,
						"tags": []
					}}
				/>
			}
			
		</section>
	);
};

export default CooperatorInterests;
