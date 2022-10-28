import React, {useContext} from "react";
import {ProfileContext} from "../../context/ProfileContext";

const Modal = ({currentItems, setCurrentItems, itemTemplate, addedItems, setAddedItems}) => {
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
										setCurrentItems([...currentItems, itemTemplate])
										// setAddedItems([...addedItems, itemTemplate])
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
