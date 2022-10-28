import React from 'react';
import SkillData from "./SkillData";
import TechLabel from "./TechLabel";

const CoopSKill = ({skill, focusedSkill, setFocusedSkill}) => {
	return (
		<div>
			<TechLabel label={skill.label}/>
			<SkillData skill={skill}
								 focusedSkill={focusedSkill}
								 setFocusedSkill={setFocusedSkill}/>
		</div>
	);
};

export default CoopSKill;
