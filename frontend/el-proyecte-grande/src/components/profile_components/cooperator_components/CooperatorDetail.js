import {useContext} from "react";
import {CooperatorContext} from "../../../context/CooperatorContext";

const CooperatorDetail = ({ fieldName, detailItems, labels}) => {
	const [showModal, setShowModal] = useContext(CooperatorContext);

	const handleAdd = () => {
		setShowModal(true);
		console.log(showModal);
	}

	return (
		<section className="coop-detail-container">
			<div className="label-container">
				<span className='field-label'>{fieldName}:</span>
				<button className="btn-add"
								onClick={e => handleAdd()}
				>
					<img src="/assets/plus.png" alt="add"/>
				</button>
			</div>
			<div className="coop-detail-item-container">
				{detailItems.map(item => (
					<div className="detail-item" key={item.id}>
						<img src={`/skill_icons/${item.internalName}.png`} alt={item.tooltipText}/>
					</div>
				))}
			</div>
		</section>
	);
};

export default CooperatorDetail;
