import React, {useState} from 'react';

const SkillData = ({skill, focusedSkill, setFocusedSkill}) => {
	const [unitSelectOn, setUnitSelectOn] = useState(false);
	const [skillQuantity, setSkillQuantity] = useState(focusedSkill ? focusedSkill.skillQuantity : skill.skillQuantity);

	function handleBlur() {
		const newFocusedSkill = {...focusedSkill}
		newFocusedSkill.skillQuantity = skillQuantity
		setFocusedSkill(newFocusedSkill)
	}

	function handleSelect(value) {
		const newFocusedSkill = {...focusedSkill}
		newFocusedSkill.skillUnit = value
		setFocusedSkill(newFocusedSkill)
		setUnitSelectOn(false)
	}


	return (
		<div className="skill-data-container">
			{focusedSkill && focusedSkill.id === skill.id &&
				<>
					{!unitSelectOn &&
						<>
							<input className='skill-quantity'
										 value={skillQuantity}
										 onChange={e => setSkillQuantity(e.target.value)}
										 onBlur={handleBlur}
							/>
							<button onClick={() => setUnitSelectOn(true)}
							>
								{focusedSkill.skillUnit}
							</button>
						</>
					}
					{/*else*/}
					{
						unitSelectOn &&
						<select className="skill-unit-select" value={focusedSkill.skillUnit}
										onChange={e => handleSelect(e.target.value)}
						>
							<option value="WEEK">Week</option>
							<option value="MONTH">Month</option>
							<option value="YEAR">Year</option>
						</select>
					}
				</>
			}
			{/*skill is displayed*/}
			{!focusedSkill &&
				<div onClick={() => setFocusedSkill(skill)}>
					<p>{skill.skillQuantity}</p>
					<p>{skill.skillUnit}</p>
				</div>
			}
		</div>
	)
};

export default SkillData;
