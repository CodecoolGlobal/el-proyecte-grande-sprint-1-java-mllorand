import Profile from "./components/profile_components/Profile";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Layout from "./components/Layout";
import Home from "./components/Home";
import {ProfileContextProvider} from "./context/ProfileContext";

function App() {
	return (
		<>
			<Router>
				<Routes>
					<Route path='/' element={<Layout children={<Home/>}/>}/>
					<Route path='/profile' element={<Layout children={
						<ProfileContextProvider>
							<Profile/>
						</ProfileContextProvider>
					}/>}/>
				</Routes>
			</Router>
		</>
	);
}

export default App;
