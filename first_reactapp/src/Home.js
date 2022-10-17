import Footer from "./Footer";
import Header from "./Header";
import { useState,useEffect } from "react"
import { useNavigate } from "react-router-dom";
import { isTokenExpired } from "./HTTPFetch";


function Home(){
        let navigate = useNavigate();

        // useEffect(() => {
        //     console.log(isTokenExpired())
        //     let indi = isTokenExpired()
    
        //     if(indi == true){
        //         console.log("token active")
        //     }else{
        //         console.log("token not active")
        //         navigate("/LoginWithPic")
        //     }
        // }, [])
        
        const showLastName=(obj)=>{
        console.log(obj.last_name);}

        const[name,setName] = useState('');
        const[job,setJob] = useState('');
        // const [userpostList, setUserPostList] = useState([]);
        const [userList, setUserList] = useState();
        
        const getAPIResponse = (pageNo)=>{
            fetch("https://reqres.in/api/users?page="+pageNo)
            .then(res=>res.json())
            .then(res2=>{
                setUserList(res2['data']);
                console.log(res2);
            })
        }
        
        // const postAPIResponse = (name,job)=>fetch('https://reqres.in/api/users', {
        //     method: 'POST',
        //     body: JSON.stringify({
        //         "name": name.target.value,
        //         "job": job.target.value
        //     }),
        //     headers: {
        //         'Content-Type': 'application/json',
        //     },
        // })
        // .then((res) => res.json())
        // .then((res2) => {
        //     setUserPostList(res2['data']);
        //     console.log(res2);
        // })

        // const btn_click=()=>{
        //     console.log(name,job)
        //     if(name == "" || name == undefined){
        //         alert("name should not be empty");
        //     }
        //     else if(job == "" || job == undefined){
        //         alert("job should not be empty");
        //     }
        //     else{
        //         alert("everything is ok");
        //     }
        // }

        return(
            <div>
                <Header menuname='home'/>
                    <h1>This is the header of the Home page</h1>
                    {/* <div>
                        {
                            usergetList.map((userGetObj,idx) => {
                            return <div key={idx}> <span className= "userName"> {userGetObj.name}</span> -- {userGetObj.job}
                            </div>
                            })
                        }
                    </div> */}
                    <input onChange= {(e) => setName(e.target.value)} type="text" placeholder="Enter name"/>
                    <input onChange= {(e) => setJob(e.target.value)} type="text" placeholder="Enter job"/>

                    {/*this shows the output of the text box on screen */}
                    <h1>{name} {job}</h1>

                    <select onChange={(e)=>getAPIResponse(e.target.value)}>
                    <option value="1"> Page 1</option>
                    <option value="2"> Page 2</option>
                    <option value="3"> Page 3</option>
                    </select>

                    <div><button onClick={getAPIResponse}>Click to get API Response</button></div>

                    {/* <div><button onClick={postAPIResponse}>Click to send POST API response</button></div> */}

                    <div>
                        {(userList && userList.length <= 0 )?<h1>No User Found</h1>:''}
                        {
                            userList && userList.map((userGetObj,idx) => {
                            return <div key={idx} onClick={(()=>showLastName(userGetObj))}> {userGetObj.first_name} {userGetObj.avatar} </div>
                        })
                        }
                    </div>

                <Footer/>
            </div>
        )
}
export default Home;