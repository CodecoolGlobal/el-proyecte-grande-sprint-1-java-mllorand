import React, {useContext, useState} from "react";
import {ProfileContext} from "../../context/ProfileContext";

const Modal = ({currentItems, setCurrentItems, itemTemplate, addedItems, setAddedItems}) => {
	const {labels} = useContext(ProfileContext);


	return (
		<div className='coop-label-chooser-modal'>
			{labels.map(label => (
				<div className="modal-item detail-item"
						 key={label.id}
				>
					<button className="btn-label"></button>
					<img src={`/tech_icons/${label.internalName}.png`}
							 alt={label.tooltipText}
							 onClick={() => {
								 itemTemplate.label = label;
								 setCurrentItems([...currentItems], itemTemplate)
								 setAddedItems([...addedItems], itemTemplate)
							 }
							 }
					/>
				</div>
			))}
		</div>
	);
};

export default Modal;
