import Profile from "./components/profile_components/Profile";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Layout from "./components/Layout";
import Home from "./components/Home";
import {ProfileContextProvider} from "./context/ProfileContext";
import {AuthContextProvider} from "./context/AuthContext";
import Login from "./components/Login";

function App() {
	return (
		<>
			<Router>
				<AuthContextProvider>
				<Routes>
					<Route path='/' element={<Layout children={<Home/>}/>}/>
					<Route path='/profile' element={<Layout children={
						<ProfileContextProvider>
							<Profile/>
						</ProfileContextProvider>
					}/>}/>
					<Route path='/login' element={<Layout children={<Login/>}/>} />
				</Routes>
				</AuthContextProvider>
			</Router>
		</>
	);
}

export default App;
