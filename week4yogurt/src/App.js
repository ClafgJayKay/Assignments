
import './App.css';
import Home from './Home';
import About from './About';
import Blog from './Blog';
import Contact from './Contact';
import Product from './Product';
import SinglePost from './SinglePost';
import './App.css';
import {BrowserRouter as Router,Routes,Route} from "react-router-dom";


function App() {
  return (
    <div className="App">
      <Router>
          <Routes>
              <Route path="/home" element={<Home/>}/>          
              <Route path="/about" element={<About/>}/>
              <Route path="/blog" element={<Blog/>}/> 
              <Route path="/contact" element={<Contact/>}/>  
              <Route path="/" element={<Home/>}/>
              <Route path="/product" element={<Product/>}/>
              <Route path="/singlepost" element={<SinglePost/>}/>
          </Routes>
      </Router>
    </div>
  );
}

export default App;
