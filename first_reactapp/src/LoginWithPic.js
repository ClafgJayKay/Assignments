import { useState } from "react";
import Header from "./Header";
import { useNavigate } from "react-router-dom";
import { postRequestWithoutHeader } from "./HTTPFetch";

function LoginWithPic(){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [output, setOutput] = useState({});
    const [errorObj, setErrorObj] = useState("");
    const [image, setImage] = useState();

    let navigate = useNavigate();

    const loginBtn = () =>{
        
        let anObj = {"email": email, "password": password}

        postRequestWithoutHeader("login", anObj)
        .then(res => {
            if(!res.ok){
                setOutput({});
                throw res;
            }else{
                setErrorObj("");
                res.json().then(res2 => {console.log(res2); setOutput(res2);
                    localStorage.setItem("userid", res2.userid); localStorage.setItem("token", res2.token); })
                navigate("/Home")
            }
        })
        .catch(err => {
            err.json().then(e => {
                setErrorObj(e.message)
            })
        })
    };

    return(
        <>
            <Header current = "LoginWithPic"/>
            <div className="container-fluid" style={{backgroundColor:"white", padding:"1%"}}>
                <div className="row row_main">
                <h1>Login here...</h1>
                    <div className="row" style={{backgroundColor:"white"}}>
                        <div className="col-6">
                        <div className="row form-group">
                            <div class="row">
                                <div className="col-4">
                                    <label>Enter email:</label>
                                </div>
                                <div className="col-7">
                                    <input value={email} name="email" type="text" className="form-control" placeholder="enter email" onChange={e => setEmail(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-4">
                                    <label>Enter password:</label>
                                </div>
                                <div className="col-7">
                                    <input value={password} name="password" type="text" className="form-control" placeholder="enter password" onChange={e => setPassword(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-12">
                                    <button className="btn btn-primary" onClick={loginBtn}>Login</button>
                                </div>
                            </div>
                        </div>
                        </div>
                        <div className="col-6">
                        <div className="row">
                            <h2>
                                {errorObj == "" ? "" : errorObj}
                                {Object.keys(output).length == 0 ? "" : <ul>
                                    <li>id: {output.userid}</li>
                                    <li>email: {output.email}</li>
                                    <li>name: {output.name}</li>
                                    <li>mobile: {output.mobilenumber}</li>
                                    <li>address: {output.address}</li>
                                    <li><img src={"http://localhost:8080/getImage/" + output.userid}></img></li>
                                </ul>}
                                
                                
                            </h2>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        
        </>
    )
}

export default LoginWithPic;