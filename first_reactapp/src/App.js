
import './App.css';
import {BrowserRouter as Router,Routes,Route} from "react-router-dom"
import Home from './Home'
import Contacts from './Contacts'
import About from './About'
import Home2 from './Home2';
import Login from './Login';
import Register from './Register';
import Update from './Update';

function App() {
  return (
    <>
    <Router>
      <Routes>
        <Route path = "/home" element = {<Home/>}/>
        <Route path = "/home2" element = {<Home2/>}/>
        <Route path = "/about" element = {<About/>}/>
        <Route path = "/contacts" element = {<Contacts/>}/>
        <Route path = "/" element = {<Home/>}/>
        <Route path="/Login" element={<Login/>}></Route>
        <Route path="/Register" element={<Register/>}></Route>
        <Route path="/Update" element={<Update/>}></Route>
      </Routes>
    </Router>
    <h1> Welcome to the React App! </h1>
    </>
   
  );
}

export default App;
