import React from 'react';

const Footer = () => {
	return (
		<footer>
			<nav id='nav-social' className='nav-footer'>
				<ul>
					<li><a href="#"><img src="/assets/facebook.png" alt="Facebook logo"/></a></li>
					<li><a href="#"><img src="/assets/Instagram.png" alt="Instagram logo"/></a></li>
					<li><a href="#"><img src="/assets/linkedin.png" alt="Linkedin logo"/></a></li>
					<li><a href="#"><img src="/assets/twitter.png" alt="Twitter logo"/></a></li>
				</ul>
			</nav>
			<nav id='nav-other' className='nav-footer'>
				<ul>
					<li>
						<p>Test</p>
					</li>
					<li>
						<p>Test</p>
					</li>
					<li>
						<p>Test</p>
					</li>
					<li>
						<p>Test</p>
					</li>
					<li>
						<p>Test</p>
					</li>
				</ul>
			</nav>
			<p className="footer-copyright">Coopportunity©</p>
		</footer>
	);
};

export default Footer;
