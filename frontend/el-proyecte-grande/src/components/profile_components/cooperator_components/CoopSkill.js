import React, {useContext, useState} from 'react';
import {ProfileContext} from "../../../context/ProfileContext";

const CoopSkill = ({skill, setSkillsAreEdited, currentSkills, setCurrentSkills, editedSkills, setEditedSkills}) => {

	const [unitSelectOn, setUnitSelectOn] = useState(false);
	const [edited, setEdited] = useState(false);

	const handleSelect = (value) => {
		skill.skillUnit = value;
		setCurrentSkills(...currentSkills, skill);
		setEditedSkills(...editedSkills, skill);
	}

	const handleChange = (value) => {
		skill.skillQuantity = value;
		setCurrentSkills(...currentSkills, skill);
		setEditedSkills(...editedSkills, skill);
	}

	return (
		<>
			<div className={ edited ? "detail-item" : "detail-item edited" }>
				<img src={`/skill_icons/${skill.label.internalName}.png`} alt={skill.label.tooltipText}/>
				{
					unitSelectOn &&
					<select className="skill-unit-select"
									onChange={e => {
										handleSelect(e.target.value)
										setEdited(true);
										setUnitSelectOn(false);
										setSkillsAreEdited(true);
									}
									}
					>
						<option value="WEEK">Week</option>
						<option value="MONTH">Month</option>
						<option value="YEAR">Year</option>
					</select>
				}

				{
					!unitSelectOn &&
					<div className='exp-container'>
						<input className='skill-quantity' value={skill.skillQuantity}
									 onChange={e => {
										 handleChange(e.target.value)
										 setEdited(true);
										 setSkillsAreEdited(true);
									 }
									 }
						/>
						<button className='skill-unit'
										onClick={() => setUnitSelectOn(true)}
						>{skill.skillUnit}</button>
					</div>
				}
			</div>
		</>
	);
};

export default CoopSkill;
