import { useState } from "react";
import Header from "./Header";

function Login(){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [output, setOutput] = useState({});
    const [errObj, setErrObj] = useState("");

    const loginBtn = () =>{
        
        let anObj = {"email": email, "password": password}
        // console.log(email + " - " + password);

        fetch("http://localhost:8080/login3",
        {
            method:"POST",
            body:JSON.stringify(anObj),
            headers:{
                'Content-Type': 'application/json'
            },
        })
        .then(res => {
            if(!res.ok){
                setOutput({});
                throw res;
            }else{
                setErrorObj("");
                res.json().then(res2 => {console.log(res2); setOutput(res2);})
            }
        })
        .catch(error => {
            error.json().then(e => {
                setErrObj(e.message)
            })
        })
    };

    return(
        <>
            <Header current = "Login"/>
            <div className="container-fluid" style={{backgroundColor:"beige", padding:"1%"}}>
                <div className="row row_main">
                <h1>Login here...</h1>
                    <div className="row" style={{backgroundColor:"gainsboro"}}>
                        <div className="row form-group">
                            <div class="row">
                                <div className="col-2">
                                    <label>Enter email:</label>
                                </div>
                                <div className="col-4">
                                    <input value={email} name="email" type="text" className="form-control" placeholder="please enter email" onChange={e => setEmail(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Enter password:</label>
                                </div>
                                <div className="col-4">
                                    <input value={password} name="password" type="text" className="form-control" placeholder="please enter password" onChange={e => setPassword(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <button className="btn btn-primary" onClick={loginBtn}>Login</button>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <h2>
                                {errObj == "" ? "" : errObj}
                                {Object.keys(output).length == 0 ? "" : <ul>
                                    <li>id: {output.id}</li>
                                    <li>email: {output.email}</li>
                                    <li>name: {output.name}</li>
                                    <li>mobile: {output.mobile}</li>
                                    <li>address: {output.address}</li>
                                </ul>}     
                            </h2>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Login;