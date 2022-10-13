import { useEffect, useState } from "react";
import Header from "./Header";

function Update(){

    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [address, setAddress] = useState();
    const [name, setName] = useState();
    const [mobile, setMobile] = useState();
    const [myArrList, setMyArrList] = useState([]);
    const [User, setUser] = useState({});

    useEffect(() => {
        getUsersAPI();
    }, [User])

    const getUsersAPI = () => {
        fetch("http://localhost:8080/userGet",
        {
            method:"GET"
        })
        .then(res => {
            if(!res.ok){
                throw res;
            }else{
                res.json().then(res2 => setMyArrList(res2))
            }
        })
        .catch(error => {
            error.json().then( e => console.log(e.message))
        })
    }

    const getaUserAPI = (num) => {
        console.log("single get called")
        fetch("http://localhost:8080/userGet/" + num,
        {
            method:"GET"
        })
        .then(res => {
            if(!res.ok){
                throw res;
            }else{
                res.json().then(res2 => {setUser(res2); setEmail(res2.email); setPassword(res2.password); setAddress(res2.address); setName(res2.name); setMobile(res2.mobile);})
            }
        })
        .catch(error => {
            error.json().then( e => console.log(e.message))
        })
    }

    const postUserAPI = () => {

        let anObj = {"email": email, "password": password, "address": address, "name": name, "mobile": mobile}

        fetch("http://localhost:8080/postUser/" + User.id,
        {
            method:"POST",
            body:JSON.stringify(anObj),
            headers:{
                'Content-Type': 'application/json'
            },
        })
        .then(res => {
            if(!res.ok){
                throw res;
            }else{
                getUsersAPI();
                res.json().then(res2 => console.log(res2))
            }
        })
        .catch(error => console.log(error))
    }

    const deleteUserAPI = () => {
        fetch("http://localhost:8080/deleteUser/" + User.id,
        {
            method:"POST",
            headers:{
                'Content-Type': 'application/json'
            },
        })
        .then(res => {
            if(!res.ok){
                throw res;
            }else{
                res.json().then(res2 => console.log(res2))
            }
        })
        .catch(error => console.log(error))
    }

    const updateBtn = () => {
        postUserAPI();
    }

    const deleteBtn = () => {
        deleteUserAPI();
        setUser({});
        getUsersAPI();
    }

    return(
        <>
            <Header current = "Update"/>
            <div className="container-fluid" style={{backgroundColor:"beige", padding:"1%"}}>
                <div className="row row_main">
                <h1>Update here...</h1>
                    <div className="row" style={{backgroundColor:"white"}}>
                        <div className="row">
                            <div className="col-6">
                                <select class="form-select" aria-label="Default select example" onChange={e => {getaUserAPI(e.target.value);}}>
                                    <option value="default" defaultValue="Selected">Select a user</option>
                                    {
                                        myArrList.map((anObj, index) => {
                                            return <option key={index} value={anObj.id}>{anObj.name}</option>
                                        })
                                    }
                                </select>
                            </div>
                        </div>

                        <div className="row form-group">
                            <div class="row">
                                <div className="col-2">
                                    <label>Email:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(aUser).length > 0 ? email : ""} name="email" type="text" className="form-control" placeholder="example@hotmail.com" onChange={e => setEmail(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Password:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(aUser).length > 0 ? password : ""} name="password" type="text" className="form-control" placeholder="some password" onChange={e => setPassword(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Address:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(aUser).length > 0 ? address : ""} name="address" type="text" className="form-control" placeholder="address" onChange={e => setAddress(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Name:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(aUser).length > 0 ? name : ""} name="name" type="text" className="form-control" placeholder="name" onChange={e => setName(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Mobile:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(aUser).length > 0 ? mobile : ""} name="mobile" type="text" className="form-control" placeholder="897123" onChange={e => setMobile(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <button className="btn btn-primary" onClick={updateBtn}>Update</button>
                                </div>
                                <div className="col-2">
                                    <button className="btn btn-danger" onClick={deleteBtn}>Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Update;