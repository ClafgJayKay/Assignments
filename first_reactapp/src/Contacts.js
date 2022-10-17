import { useState, useEffect } from "react";
import Footer from "./Footer";
import Header from "./Header";
import { useNavigate } from "react-router-dom";
import { isTokenExpired } from "./HTTPFetch";

function Contacts(){

    let navigate = useNavigate();

    useEffect(() => {
        console.log(isTokenExpired())
        let indi = isTokenExpired()

        if(indi == true){
            console.log("token active")
        }else{
            console.log("token not active")
            navigate("/LoginWithPic")
        }
    }, [])

    return(
        <div>
            <Header menuname='contacts'/>
            <h1>this is the contacts page</h1>
            <Footer/>
        </div>
    )
}

export default Contacts;