import Footer from "./Footer";
import Header from "./Header";
import {useState} from "react"

function About(){
    let peopleList = [
        {"name":"john",'age':55},
        {"name":"jane",'age':55},
        {"name":"aaron",'age':20},
        {"name":"may",'age':20},
    ];
    let name = "this is a name";
    const[headingClassName,setHeadingClassName] = useState('heading_1');

    return(
        <div>
            <Header/>
            <h1>This is the header of the About Page</h1>
            <h2 className={headingClassName}>{name}</h2>
            <button onClick={()=>setHeadingClassName('heading_1')}>Heading Class 1</button>
            <button onClick={()=>setHeadingClassName('heading_2')}>Heading Class 2</button>
            <button onClick={()=>setHeadingClassName('heading_3')}>Heading Class 3</button>
            <ul>
                {
                   peopleList.map((peopleObj,idx)=>{
                    return <li key={idx} className={peopleObj.age>50?'heading_1':"heading_2"}>{peopleObj.name} -- {peopleObj.age}</li>
                   }) 
                }
            </ul>
            <Footer/>
        </div>
    )
}

export default About;