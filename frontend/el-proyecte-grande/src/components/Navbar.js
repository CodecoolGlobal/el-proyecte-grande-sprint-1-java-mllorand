import React from 'react';

const Navbar = () => {
	return (
		<header>
			<img id='nav-logo' src='/assets/logo.png' alt="logo"/>
			<nav>
				<button className="btn-opp-browse btn-nav">Opportunities</button>
				<ul className='nav-links'>
					<button className="btn-nav btn-forum">Forum</button>
					<button className="btn-nav">Profile</button>
					<button className="btn-nav">Logout</button>
				</ul>
			</nav>
		</header>
	);
};

export default Navbar;
