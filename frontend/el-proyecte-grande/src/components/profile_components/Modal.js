import React, {useContext} from "react";
import {ProfileContext} from "../../context/ProfileContext";

const Modal = ({itemTemplate, setShowModal, currentSkills, setCurrentSkills, setFocusedSkill}) => {
	const {labels} = useContext(ProfileContext);

	return (
		<div className='coop-label-chooser-modal'>
			{labels.map(label => (
				<div className="modal-item detail-item"
						 key={label.id}
				>
					<button className="btn-label"
									onClick={() => {
										itemTemplate.label = label;
										let newCurrentSkills = [...currentSkills]
										newCurrentSkills = [...newCurrentSkills, itemTemplate]
										setFocusedSkill(itemTemplate)
										setCurrentSkills(newCurrentSkills)
										setShowModal(false)
									}
									}>
						<img src={`/tech_icons/${label.internalName}.png`} alt={label.tooltipText}/>
					</button>
				</div>
			))}
		</div>
	);
};

export default Modal;
