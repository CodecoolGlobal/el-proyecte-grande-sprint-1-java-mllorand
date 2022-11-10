import React, {useState} from 'react';

const Tag = ({tag, focusedTag, setFocusedTag, focusedInterest, setFocusedInterest, tags, setTags, interestBeingEdited}) => {
	const [tagName, setTagName] = useState(focusedTag ? focusedTag.name : tag.name);

	function handleBlur() {
		const newFocusedTag = {...focusedTag}
		newFocusedTag.name = tagName
		setFocusedTag(newFocusedTag)
		let newFocusedInterest = {...focusedInterest}
		newFocusedInterest.tags = [...newFocusedInterest.tags, newFocusedTag]
		setTags([...tags, newFocusedTag])
		setFocusedInterest(newFocusedInterest)
	}

	return (
		<div className="single-tag-container">
			{interestBeingEdited
				? focusedTag && focusedTag.id === tag.id
					? <input className='tag-input'
								 value={tagName}
								 onChange={e => setTagName(e.target.value)}
								 onBlur={handleBlur}
					/>
					: <button onClick={e => console.log(`editing ${tagName} tag`)}>
						<span>{tagName}</span>
					</button>
				: <span>{tagName}</span>
			}
		</div>
	);
};

export default Tag;
