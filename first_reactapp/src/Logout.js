import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { postRequestWithHeader } from "./HTTPFetch";


function Logout(){

    let navigate = useNavigate();

    const logout = () => {

        console.log(localStorage.getItem("userid"));
        console.log(localStorage.getItem("token"));

    postRequestWithHeader("logout/")
        .then(res => {
            if(!res.ok){
                throw res;
            }else{
                localStorage.removeItem("userid");
                localStorage.removeItem("token");
                res.json().then(res2 => console.log(res2));
                navigate("/LoginWithPic");
            }
        })
        .catch(err =>{
            console.log(err);
        })
    }

    useEffect(() => {
        logout();
    }, [])

    return(
        <>
        </>
    )
}

export default Logout;