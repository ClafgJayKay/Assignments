import { useState } from "react";
import Header from "./Header";

function Register(){

    const [name, setName] = useState();
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [address, setAddress] = useState();
    const [mobilenumber, setMobilenumber] = useState();

    const registerBtn = () =>{
        
        let anObj = {"name": name, "email": email, "password": password, "address": address, "mobilenumber": mobilenumber}
        console.log(name + " - " + email + " - " + password + " - " + address + " - " + mobilenumber);
        fetch("http://localhost:8080/createUser",
        {
            method:"POST",
            body:JSON.stringify(anObj),
            headers:{
                'Content-Type': 'application/json'
            },
        })
        .then(res => res.json())
        .then(res2 => console.log(res2))
        .catch(error => console.log(error))
    };

    return(
        <>
            <Header current = "Register"/>
            <div className="container-fluid" style={{backgroundColor:"white", padding:"1%"}}>
                <div className="row row_main">
                <h1>Register here...</h1>
                    <div className="row" style={{backgroundColor:"white"}}>
                        <div className="row form-group">
                            <div class="row">
                                <div className="col-2">
                                    <label>Enter name:</label>
                                </div>
                                <div className="col-4">
                                    <input value={name} name="email" type="text" className="form-control" placeholder="enter name" onChange={e => setName(e.target.value)}/>
                                </div>
                            </div>
                            <div class="row">
                                <div className="col-2">
                                    <label>Enter email:</label>
                                </div>
                                <div className="col-4">
                                    <input value={email} name="email" type="text" className="form-control" placeholder="enter email" onChange={e => setEmail(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Enter password:</label>
                                </div>
                                <div className="col-4">
                                    <input value={password} name="password" type="text" className="form-control" placeholder="enter password" onChange={e => setPassword(e.target.value)}/>
                                </div>
                            </div>
                            <div class="row">
                                <div className="col-2">
                                    <label>Enter address:</label>
                                </div>
                                <div className="col-4">
                                    <input value={address} name="email" type="text" className="form-control" placeholder="enter address" onChange={e => setAddress(e.target.value)}/>
                                </div>
                            </div>
                            <div class="row">
                                <div className="col-2">
                                    <label>Enter mobile number:</label>
                                </div>
                                <div className="col-4">
                                    <input value={mobilenumber} name="email" type="text" className="form-control" placeholder="enter mobile number" onChange={e => setMobilenumber(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <button className="btn btn-primary" onClick={registerBtn}>Register</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Register;