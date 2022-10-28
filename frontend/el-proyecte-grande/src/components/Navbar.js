import React from 'react';
import {Link} from "react-router-dom";

const Navbar = () => {
	return (
		<header>
			<img id='nav-logo' src='/assets/logo.png' alt="logo"/>
			<nav>
				<button className="btn-opp-browse btn-nav">Opportunities</button>
				<ul className='nav-links'>
					<button className="btn-nav">
						<Link to='/profile'>Profile</Link>
					</button>
					<button className="btn-nav">
						<Link to='/login'>Login</Link>
					</button>
					<button className="btn-nav">Logout</button>
				</ul>
			</nav>
		</header>
	);
};

export default Navbar;
