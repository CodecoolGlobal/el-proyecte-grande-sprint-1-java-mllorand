import React, {useState} from 'react';
import {v4 as uuid} from 'uuid';
import Tag from "./Tag";

const InterestData = ({interest, focusedInterest, setFocusedInterest}) => {
	const [tags, setTags] = useState(interest.tags);
	const [focusedTag, setFocusedTag] = useState(null);


	function handleAddTag() {
		const newTag = {
			id: null,
			name: '...'
		}
		setTags([...tags, newTag])
		setFocusedTag(newTag)
	}

	return (
		<div className="interest-data-container">
			{focusedInterest && focusedInterest.id === interest.id &&
				<div className="tag-container">
					<button onClick={handleAddTag}
					>#
					</button>
				</div>
			}
			{
				tags.map(tag => (
					<Tag tag={tag} key={uuid()}
						 tags={tags}
						 setTags={setTags}
						 focusedTag={focusedTag}
						 setFocusedTag={setFocusedTag}
						 focusedInterest={focusedInterest}
						 setFocusedInterest={setFocusedInterest}
						 interestBeingEdited={focusedInterest && focusedInterest.id === interest.id}
					/>
				))
			}
		</div>
	);
};

export default InterestData;
