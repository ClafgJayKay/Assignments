import { useState } from "react";
import Footer from "./Footer";
import Header from "./Header";

function Contacts(){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [output, setOutput] = useState("");

    const postBtn = () => {
        let exampleObj = {"username": username, "password": password};

            fetch("http://localhost:8080/login",
            {
                method:"POST",
                body:JSON.stringify(exampleObj),
                headers:{
                    'Content-Type': 'application/json'
                },
            })
            .then(res => res.json())
            .then(res2 => {console.log(res2); setOutput(res2)})
            .catch(err => console.log(err))   
    }

    return(
        <div>
            <Header menuname='contacts'/>

            <div className="container-fluid py-5">
                <div className="container py-5">
                   
                    <div className="row justify-content-center">
                        <div className="col-lg-9">
                            <div className="contact-form bg-light rounded p-5">
                                <div id="success"></div>
                                <form name="sentMessage" id="contactForm" noValidate="novalidate">
                                    <div className="form-row">
                                        <div className="col-sm-6 control-group">
                                            <input onChange={e => setUsername(e.target.value)} type="text" className="form-control p-4" id="name" placeholder="Enter username" required="required" data-validation-required-message="Please enter a name" />
                                            <p className="help-block text-danger"></p>
                                        </div>
                                        <div className="col-sm-6 control-group">
                                            <input onChange={e => setPassword(e.target.value)} type="text" className="form-control p-4" placeholder="Enter password" required="required" data-validation-required-message="Please enter a password" />
                                            <p className="help-block text-danger"></p>
                                        </div>
                                    </div>
                                </form>
                                <div>
                                    <button onClick={postBtn} className="btn btn-primary btn-block py-3 px-5" type="submit" id="sendMessageButton">Login</button>
                                </div>
                                <span>{JSON.stringify(output)}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer/>
        </div>
    )
}

export default Contacts;