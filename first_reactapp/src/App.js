import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router,Routes,Route} from "react-router-dom"
import Home from './Home'
import Contacts from './Contacts'
import About from './About'

function App() {
  return (
    <>
    <Router>
      <Routes>
        <Route path = "/home" element = {<Home/>}/>
        <Route path = "/about" element = {<About/>}/>
        <Route path = "/contacts" element = {<Contacts/>}/>
        <Route path = "/" element = {<Home/>}/>
      </Routes>
    </Router>
    <h1> Welcome to the React App! </h1>
    </>
   
  );
}

export default App;
