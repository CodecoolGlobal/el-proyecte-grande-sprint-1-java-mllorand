import React, {useState} from 'react';
import TechLabel from "./TechLabel";
import InterestData from "./InterestData";

const CoopInterest = ({interest, focusedInterest, setFocusedInterest}) => {
	const [tags, setTags] = useState(interest.tags);
	const [focusedTag, setFocusedTag] = useState(null);

	return (
		<div>
			<TechLabel label={interest.label}/>
			<InterestData interest={interest}
										focusedInterest={focusedInterest}
										setFocusedInterest={setFocusedInterest}
										tags={tags}
										setTags={setTags}
										setFocusedTag={setFocusedTag}
			/>
		</div>
	);
};

export default CoopInterest;
