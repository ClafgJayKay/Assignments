import { useState } from "react";

function UserList(props){
    const showUser=(userObj)=>{
        alert(userObj.first_name);
    }

    const [userList, setUserList] = useState();

    const getAPIResponse = (pageNo)=>{
        fetch("https://reqres.in/api/users?page="+pageNo)
        .then(res=>res.json())
        .then(res2=>{
            setUserList(res2['data']);
            console.log(res2);
        })
    }
    
    return(
        <>
        <h1>User List</h1>
        {(props.userList && props.userList.length <=0)?<h1>No User Found</h1>:''}
            {
                  
                props.userList && props.userList.map((userObj,idx)=>{
                    return  <div onClick={()=>showUser(userObj)} key={idx}>{userObj.first_name} {userObj.email} {userObj.id} </div>
                   }) 
            }

                    <select onChange={(e)=>getAPIResponse(e.target.value)}>
                    <option value="1"> Page 1</option>
                    <option value="2"> Page 2</option>
                    <option value="3"> Page 3</option>
                    </select>

                    <button onClick={()=>this.getAPIResponse(1)}>getAPIResponse</button>

        </>
    )

}

export default UserList;