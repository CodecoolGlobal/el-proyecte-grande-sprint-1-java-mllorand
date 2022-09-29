import React from 'react';

const Profile = () => {
	return (
		<article>
			<aside id="user-container">
				<div id="profile-img"></div>
				<section id='user-details'>
					<div className="usr-detail">
						<span className='field-label'>Username:</span>
						<span className='field'>Sanya</span>
					</div>
					<div className="usr-detail">
						<span className='field-label'>Full Name:</span>
						<span className='field'>Kovács Sándor</span>
					</div>
					<div className="usr-detail">
						<span className='field-label'>Age:</span>
						<span className='field'>27</span>
					</div>
					<div className="usr-detail">
						<span className='field-label'>Gender:</span>
						<span className='field'>Male</span>
					</div>
					<div className="usr-detail">
						<span className='field-label'>Email:</span>
						<span className='field'>sanya@gmail.com</span>
					</div>
				</section>
				<section id='user-groups'>
					<p className='field-label'>My groups:</p>
					<div className="group-img-container">
						<img src="" alt="" className="group-img"/>
						<img src="" alt="" className="group-img"/>
						<img src="" alt="" className="group-img"/>
						<img src="" alt="" className="group-img"/>
						<img src="" alt="" className="group-img"/>
					</div>
				</section>
			</aside>
			<main>
				<section id="coop-details">

					<div className="coop-detail-container">
						<div className="label-container">
							<span className='field-label'>Skills:</span>
							<button className="btn-add"><img src="" alt=""/></button>
						</div>
						<div className="coop-detail-item-container">
							<div className="detail-item">
								<img src="" alt=""/>
								<div className='exp-container'>
									<p>2</p>
									<p>yrs</p>
								</div>
							</div>
						</div>
					</div>

					<div className="coop-detail-container">
						<div className="label-container">
							<span className='field-label'>Interests:</span>
							<button className="btn-add"><img src="" alt=""/></button>
						</div>
						<div className="coop-detail-item-container">
							<div className="detail-item">
								<img src="" alt=""/>
								<select name="prio" id="prio">
									<option value="">First</option>
									<option value="">Second</option>
									<option value="">Third</option>
								</select>
							</div>
						</div>
					</div>

					<div className="coop-detail-container">
						<div className="label-container">
							<span className='field-label'>Strengths:</span>
							<button className="btn-add"><img src="" alt=""/></button>
						</div>
						<div className="coop-detail-item-container">
							<div className="detail-item">
								<img src="" alt=""/>
							</div>
						</div>
					</div>

					<div className="coop-detail-container">
						<div className="label-container">
							<span className='field-label'>wanna start:</span>
							<button className="btn-add"><img src="" alt=""/></button>
						</div>
						<div className="coop-detail-item-container">
							<div className="detail-item">
								<img src="" alt=""/>
							</div>
						</div>
					</div>

					<div className="coop-detail-container">
						<div className="label-container">
							<span className='field-label'>want to improve:</span>
							<button className="btn-add"><img src="" alt=""/></button>
						</div>
						<div className="coop-detail-item-container">
							<div className="detail-item">
								<img src="" alt=""/>
							</div>
						</div>
					</div>

				</section>
			</main>
		</article>
	);
};

export default Profile;
