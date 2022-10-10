import Profile from "./components/profile_components/Profile";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Layout from "./components/Layout";
import Home from "./components/Home";

function App() {
  return (
    <>
      <Router>
          <Routes>
            <Route path='/' element={<Layout children={<Home />}/>}/>
            <Route path='/profile' element={<Layout children={<Profile id={}/>}/>}/>
          </Routes>
      </Router>
    </>
  );
}

export default App;
