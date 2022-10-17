import React, {useContext, useState} from "react";
import {ProfileContext} from "../../context/ProfileContext";

const Modal = ({fieldName, handleAdd}) => {
	const {labels} = useContext(ProfileContext);
	const [prio, setPrio] = useState(null);
	const [weightQuantity, setWeightQuantity] = useState(null);
	const [weightUnit, setWeightUnit] = useState(null);

	return (
		<div className='coop-label-chooser-modal'>
			{labels.map(label => (
				<div className="modal-item detail-item"
						 key={label.id}
				>
					<img src={`/skill_icons/${label.internalName}.png`}
							 alt={label.tooltipText}
							 onClick={() => {
								 if (prio) handleAdd(label, prio);
								 else if (weightQuantity && weightUnit) handleAdd(label, weightQuantity, weightUnit);
								 else handleAdd(label);
							 }}
					/>
					{fieldName === 'skills' &&
						<>
							<input className='weight-quantity'
										 onChange={(e) => setWeightQuantity(e.target.value)}
							></input>
							<input className='weight-unit'
										 onChange={(e) => setWeightUnit(e.target.value)}
							></input>
						</>}
					{fieldName === 'interests' &&
						<select name="prio" id="prio"
										onChange={(e) => setPrio(e.currentTarget.value)}
						>
							<option value="Primary">Primary</option>
							<option value="Secondary">Secondary</option>
							<option value="Tertiary">Tertiary</option>
						</select>
					}
				</div>
			))}
		</div>
	);
};

export default Modal;
