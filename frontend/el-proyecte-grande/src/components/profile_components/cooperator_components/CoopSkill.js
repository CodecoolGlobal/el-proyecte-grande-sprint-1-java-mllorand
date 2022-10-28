import React, {useContext, useEffect, useState} from 'react';
import {ProfileContext} from "../../../context/ProfileContext";

const CoopSkill = ({
										 skill,
										 setSkillsAreEdited,
										 currentSkills,
										 setCurrentSkills,
										 editedSkills,
										 setEditedSkills,
										 addedSkills,
										 setAddedSkills
									 }) => {

	const [unitSelectOn, setUnitSelectOn] = useState(false);
	const [edited, setEdited] = useState(false);
	const [skillQuantity, setSkillQuantity] = useState(skill['skillQuantity']);
	const [skillUnit, setSkillUnit] = useState(skill['skillUnit']);
	const {
		userData,
		setUserData,
		cooperatorData,
		setCooperatorData,
		labels,
		setLabels
	} = useContext(ProfileContext);


	// useEffect(() => {
	// 	let skillItem = {
	// 		id: skill.id,
	// 		label: skill.label,
	// 		skillQuantity: skillQuantity,
	// 		skillUnit: skillUnit
	// 	};
	// 	setCurrentSkills(currentSkills.map(item => (
	// 		item.id === skillItem.id ? skillItem : item
	// 	)));
	// 	setAddedSkills([...addedSkills, skillItem]);
	// }, [skillUnit]);

	const handleSelect = (value) => {
		console.log(value)
		setSkillUnit(value);
		let skillItem = {
			id: skill.id,
			label: skill.label,
			skillQuantity: skillQuantity,
			skillUnit: skillUnit
		};
		let newCooperatorData = {...cooperatorData}
		newCooperatorData.skill.skillUnit = skillUnit;
		setCooperatorData(newCooperatorData);
		setCurrentSkills(currentSkills.map(item => (
			item.id === skillItem.id ? skillItem : item
		)));
		setAddedSkills([...addedSkills, skillItem]);

	}

	const handleChange = (value) => {
		console.log(value)
		setSkillQuantity(value)
		setCurrentSkills(currentSkills.map(item => (
			item.id === skill.id ? skill : item
		)));
		setAddedSkills([...addedSkills, skill])

		// let newCooperatorData = {...cooperatorData};
		// newCooperatorData['skill'].skillQuantity = value;
		// setCooperatorData(newCooperatorData);

		// let skillItem = {
		// 	id: skill.id,
		// 	label: skill.label,
		// 	skillQuantity: skillQuantity,
		// 	skillUnit: skillUnit
		// };





	}


	// const handleKeyDown = (event) => {
	// 	if (event.key === 'Enter') {
	// 		console.log("enter")
	//
	// 		let skillItem = {
	// 			id: skill.id,
	// 			label: skill.label,
	// 			skillQuantity: skillQuantity,
	// 			skillUnit: skillUnit
	// 		};
	//
	// 		let newCooperatorData = {...cooperatorData}
	// 		newCooperatorData.skill.skillQuantity = skillQuantity;
	// 		setCooperatorData(newCooperatorData);
	//
	// 		setCurrentSkills(currentSkills.map(item => (
	// 			item.id === skillItem.id ? skillItem : item
	// 		)));
	// 		setAddedSkills([...addedSkills, skillItem])
	// 	}
	// }

	return (<>
		<div className={edited ? "detail-item" : "detail-item edited"}>
			<img src={`/skill_icons/${skill.label.internalName}.png`} alt={skill.label.tooltipText}/>
			{unitSelectOn && <select className="skill-unit-select" value={skillUnit.toString()}
															 onChange={e => {
																 handleSelect(e.target.value)
																 setEdited(true);
																 setUnitSelectOn(false);
																 setSkillsAreEdited(true);
															 }}
			>
				<option value="WEEK">Week</option>
				<option value="MONTH">Month</option>
				<option value="YEAR">Year</option>
			</select>}

			{!unitSelectOn &&
				<div className='exp-container'>
					<input className='skill-quantity' value={skillQuantity}
								 onChange={e => {
									 handleChange(e.target.value)
									 setEdited(true);
									 setSkillsAreEdited(true);
								 }}
						// onKeyDown={handleKeyDown}
					/>
					<button className='skill-unit'
									onClick={() => setUnitSelectOn(true)}
					>{skill.skillUnit}dadaadadadad
					</button>
				</div>}
		</div>
	</>);
};

export default CoopSkill;
