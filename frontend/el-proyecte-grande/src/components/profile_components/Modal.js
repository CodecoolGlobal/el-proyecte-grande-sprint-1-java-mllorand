import React, {useContext} from "react";
import {ProfileContext} from "../../context/ProfileContext";

const Modal = ({itemTemplate, setShowModal, currentItems, setCurrentItems, setFocusedItem}) => {
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
										let newCurrentItems = [...currentItems]
										newCurrentItems = [...newCurrentItems, itemTemplate]
										setFocusedItem(itemTemplate)
										setCurrentItems(newCurrentItems)
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
