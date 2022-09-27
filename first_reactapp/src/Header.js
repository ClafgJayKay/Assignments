import './App.css';
import { useState,useEffect } from 'react';


function Header(props){
    // let name = 'this is variable';
    const[isExist,setisExist] = useState(false);

    useEffect(()=>{
        if(localStorage.getItem("token") != '' && localStorage.getItem("token") != undefined){
            setisExist(true);
        }else{
            setisExist(false)
        }
    },[])

    return(
        <ul className='menu'>
            <li className={props.menuname =='home'?"active":''} ><a href="home">Home</a></li>
            <li className={props.menuname =='home2'?"active":''} ><a href="home2">Home 2</a></li>
            <li className={props.menuname =='about'?"active":''} ><a href="about">About</a></li>
            <li className={props.menuname =='contacts'?"active":''} ><a href="contacts">Contacts</a></li>
            {isExist?<li><a href="#">Logout</a></li>:null}

        </ul>
    )
}

export default Header;