import {useContext} from "react";
import {ProfileContext} from "../../context/ProfileContext";

const Modal = ({handleAdd}) => {
	const {labels} = useContext(ProfileContext);

	return (
		<div className='coop-label-chooser-modal'>
			{labels.map(label => (
				<div className="modal-item detail-item"
						 key={label.id}
						 onClick={() => handleAdd(label)}
				>
					<img src={`/skill_icons/${label.internalName}.png`}
							 alt={label.tooltipText}/>
				</div>
			))}
		</div>
	);
};

export default Modal;
