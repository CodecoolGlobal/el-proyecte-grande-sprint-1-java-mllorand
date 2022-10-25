import React, {useContext, useState} from 'react';
import {ProfileContext} from "../../../context/ProfileContext";

const CoopDetailItem = ({ item }) => {

	const [ unitSelectOn, setUnitSelectOn ] = useState(false);
	const { cooperatorData, setCooperatorData } = useContext(ProfileContext);

	const handleChange = (value) => {

	}

	return (
		<div className="detail-item">
			<img src={`/skill_icons/${item.label.internalName}.png`} alt={item.label.tooltipText} />

			{
				unitSelectOn &&
				<select className="skill-unit-select"
						onChange={e => handleChange(e.target.value)}
				>
					<option value="WEEK">Week</option>
					<option value="MONTH">Month</option>
					<option value="YEAR">Year</option>
				</select>
			}

			{
				!unitSelectOn &&
				<div className='exp-container'>
					<input className='skill-quantity' value={item.skillQuantity}></input>
					<button className='skill-unit'
							value={item.skillUnit}
							onClick={() => setUnitSelectOn(true)}
					></button>
				</div>
			}

		</div>
	);
};

export default CoopDetailItem;
