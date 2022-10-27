import React, {useState} from 'react';
import Tag from "../../Tag";

const CoopInterest = ({
												interest,
												setInterestsAreEdited,
												currentInterests,
												setCurrentInterests,
												editedInterests,
												setEditedInterests
											}) => {

	const [edited, setEdited] = useState(false);
	const [currentTags, setCurrentTags] = useState(interest.tags);
	const [tagsAreEdited, setTagsAreEdited] = useState(false);
	const [editedTags, setEditedTags] = useState();

	const handleDrag = () => {
		return null;
	}

	return (
		<>
			<div className={edited ? "detail-item" : "detail-item edited"}>
				<img src={`/tech_icons/${interest}.label.internalName}.png`} alt={interest.label.tooltipText}/>
				<div className="tag-container">
					{interest.tags.map(tag => (
						<Tag key={tag.id}
								 name={tag.name}
						/>
					))}
				</div>
			</div>
		</>
	);
};

export default CoopInterest;
