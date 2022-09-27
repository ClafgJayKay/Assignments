

import React from 'react';
import Comp1 from './Comp1';
import Comp2 from './Comp2';
import Header from './Header';
import UserList from './UserList';

class Home2 extends React.Component{
    constructor(){
       super(); //this has to be declared first
       this.state = {
        "name":"hi how are you",
        "job":"",   
        "password":"",
        "age":45,
        "city":"some city",
        "countryName":'',
        "peopleList":[],
        "userList":[],
        "headingClass":"",
        "showComp1":false,
        "showComp2":false,
        "message": ""
       }
       this.getAPIResponse(1);//will be called during the page load.

       //this.state.name //access the varible from state.
       //this.state.age
    }
     getAPIResponse = (pageNo)=>{
        fetch("https://reqres.in/api/users?page="+pageNo)
        .then(res=>res.json())
        .then(res2=>{
            this.setState({"userList":res2['data']});//update the server respon to the state.
            console.log(res2);
        })
    }

    postAPIResponse=(sampleName, sampleJob)=>{

        let param = {
            "name":sampleName,
            "job":sampleJob
        }
        fetch(
        "https://reqres.in/api/users",
        {method: "POST", 
        body:JSON.stringify(param)}
        ).then(res=>res.json())
        .then(res2=>{
            this.setState({"userList":res2['data']});
        })
    }
    changeName=()=>{
        this.setState({"name":"hi i have updated"});
    }
    validate=()=>{
       // this.setState({"name":"new value","age":"85"});//update state.
       if(this.state.name == ""){
        alert("name is empty");
       }else if(this.state.password == ""){
        alert("password is empty");
       }else{
        alert("everything is ok ")
       }
       
       // console.log("button clicked",this.state.name);
    }
    
    //return the html from this clas compoentn
    render(){
        return (
            <div>
                <Header menuname="home2"/>
                <h1>this is class component</h1>
                <input type="text" onChange={(e)=>this.setState({"name":e.target.value})} />
                <input type="text" onChange={(e)=>this.setState({"password":e.target.value})} />

                <button onClick={this.validate}>Confirm</button>
                
                <button onClick={this.changeName}>Change the name</button>

                <div>
                    {/* <button onClick={()=>this.getApiResponse(1)}>getApiResponse</button> */}
                    {/* above gets the first page of the get api on click */}


                    {/* <select onChange={(e)=>this.getApiResponse(e.target.value)}>
                        <option value="1"> page 1</option>
                        <option value="2"> page 2</option>
                        <option value="3"> page 3</option>
                        <option value="4"> page 4</option>
                    </select> */}
                    {/* above gets the diff pages of the get api on page change */}

                    <UserList userList={this.state.userList}/> 
                    {/*this is brought from UserList functional component which has the get api request*/}

                <h2 className={this.state.headingClass}>asdfasdfsdf</h2>
                <button onClick={()=>this.setState({"headingClass":"heading_1"})}>Heading Class 1</button>
                <button onClick={()=>this.setState({"headingClass":"heading_2"}) }>Heading Class 2</button>
                <button onClick={()=>this.setState({"headingClass":"heading_3"})}>Heading Class 3</button>
                </div>

                {this.state.showComp1?<Comp1/>:null}
                {this.state.showComp2?<Comp2/>:null}
                <button onClick={()=>this.setState({'showComp1':true})}>show Comp1</button>
                <button onClick={()=>this.setState({'showComp2':true})}>show Comp2</button>
                <button onClick={()=>this.setState({'showComp1':false})}>hide Comp1</button>
                <button onClick={()=>this.setState({'showComp2':false})}>hide Comp2</button>
            </div>
        )
    }
}

export default Home2;