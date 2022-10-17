import './App.css';
import { useState,useEffect } from 'react';


function Header(props){
    // let name = 'this is variable';
    const[isExist,setisExist] = useState(false);
    const[isLoggedin, setIsLoggedIn] = useState(false);

    const checkLoginToken=()=>{
        let token = localStorage.getItem("token");
        if (token == null || token == ""){
            setIsLoggedIn(false);
        }
        else{
            setIsLoggedIn(true);
        }
    }

    // useEffect(()=>{
    //     if(localStorage.getItem("token") != "" && localStorage.getItem("token") != null){
    //         setisExist(true);
    //     }else{
    //         setisExist(false)
    //     }
    // },[])

    useEffect(checkLoginToken,[]);

    return(
        <ul className='menu'>
            <li className={props.menuname =='home'?"active":''} ><a href="home">Home</a></li>
            <li className={props.menuname =='home2'?"active":''} ><a href="home2">Home 2</a></li>
            <li className={props.menuname =='about'?"active":''} ><a href="about">About</a></li>
            <li className={props.menuname =='contacts'?"active":''} ><a href="contacts">Contacts</a></li>

            {!isLoggedin?<>
            <li className={props.current == "Login" ? "isActive" : ""}><a href="Login">Login</a></li>
            <li className={props.current == "Register" ? "isActive" : ""}><a href="Register">Register</a></li>
            </>:""}

            {isLoggedin?<>
            <li className={props.current == "Logout" ? "isActive" : ""}><a href="Logout">Logout</a></li>
            </>:""}

            <li className={props.current == "Update" ? "isActive" : ""}><a href="Update">Update</a></li>
            <li className={props.current == "LoginWithPic" ? "isActive" : ""}><a href="LoginWithPic">Login With Pic</a></li>
            {isExist?<li><a href="#">Logout</a></li>:null}

        </ul>
    )
}

export default Header;