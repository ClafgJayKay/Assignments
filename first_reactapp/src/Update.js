import { useEffect, useState } from "react";
import Header from "./Header";

function Update(){

    const [name, setName] = useState();
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [address, setAddress] = useState();
    const [mobilenumber, setMobilenumber] = useState();
    const [myArrList, setMyArrList] = useState([]);
    const [User, setUser] = useState({});

    useEffect(() => {
        getAllUsersAPI();
    }, [User])

    const getAllUsersAPI = () => {
        fetch("http://localhost:8080/user",
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

    const getaUserAPI = (id) => {
        console.log("calling single user")
        fetch("http://localhost:8080/user/" + id,
        {
            method:"GET"
        })
        .then(res => {
            if(!res.ok){
                throw res;
            }else{
                res.json().then(res2 => {setUser(res2); setEmail(res2.email); setPassword(res2.password); setAddress(res2.address); setName(res2.name); setMobilenumber(res2.mobilenumber);})
            }
        })
        .catch(error => {
            error.json().then( e => console.log(e.message))
        })
    }

    const updateUserAPI = () => {

        let anObj = {"email": email, "password": password, "address": address, "name": name, "mobilenumber": mobilenumber}

        fetch("http://localhost:8080/updateUser/" + User.id,
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
                getAllUsersAPI();
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
        updateUserAPI();
    }

    const deleteBtn = () => {
        deleteUserAPI();
        setUser({});
        getAllUsersAPI();
    }

    return(
        <>
            <Header current = "Update"/>
            <div className="container-fluid" style={{backgroundColor:"white", padding:"1%"}}>
                <div className="row row_main">
                <h1>Update Page</h1>
                    <div className="row" style={{backgroundColor:"white"}}>
                        <div className="row">
                            <div className="col-6">
                                <select class="form-select" aria-label="select user" onChange={e => {getaUserAPI(e.target.value);}}>
                                    <option value="default" defaultValue="Selected">Select user</option>
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
                                    <input value={Object.keys(User).length > 0 ? email : ""} name="email" type="text" className="form-control" placeholder="email" onChange={e => setEmail(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Password:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(User).length > 0 ? password : ""} name="password" type="text" className="form-control" placeholder="password" onChange={e => setPassword(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Address:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(User).length > 0 ? address : ""} name="address" type="text" className="form-control" placeholder="address" onChange={e => setAddress(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Name:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(User).length > 0 ? name : ""} name="name" type="text" className="form-control" placeholder="name" onChange={e => setName(e.target.value)}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-2">
                                    <label>Mobile:</label>
                                </div>
                                <div className="col-4">
                                    <input value={Object.keys(User).length > 0 ? mobilenumber : ""} name="mobile" type="text" className="form-control" placeholder="mobile number" onChange={e => setMobilenumber(e.target.value)}/>
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