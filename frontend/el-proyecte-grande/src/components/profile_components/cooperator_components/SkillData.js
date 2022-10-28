import React, {useState} from 'react';

const SkillData = ({skill, focusedSkill, setFocusedSkill}) => {
	const [unitSelectOn, setUnitSelectOn] = useState(false);
	console.log('skill', skill)
	console.log('focused', focusedSkill)


	function handleChange(value) {
		const newFocusedSkill = {...focusedSkill}
		newFocusedSkill.skillQuantity = value
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
										 value={focusedSkill.skillQuantity}
										 onChange={e => handleChange(e.target.value)}
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
			{focusedSkill && focusedSkill.id !== skill.id &&
				<div onClick={setFocusedSkill(skill)}>
					<p>{skill.skillQuantity}</p>
					<p>{skill.skillUnit}</p>
				</div>
			}
		</div>
	)
};

export default SkillData;
