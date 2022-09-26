import Footer from "./Footer";
import Header from "./Header";
import { useState } from "react"


function Home(){
        const[name,setName] = useState('');
        const[job,setJob] = useState('');
        const [userList, setUserList] = useState([]);
        
        const postAPIResponse = (name,job)=>fetch('https://reqres.in/api/users', {
            method: 'POST',
            body: JSON.stringify({
                "name": name.target.value,
                "job": job.target.value
            }),
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then((res) => res.json())
        .then((res2) => {
            setUserList(res2['data']);
            console.log(res2);
        })

        const btn_click=()=>{
            console.log(name,job)
            if(name == "" || name == undefined){
                alert("name should not be empty");
            }
            else if(job == "" || job == undefined){
                alert("job should not be empty");
            }
            else{
                alert("everything is ok");
            }
        }

        return(
            <div>
                <Header/>
                    <h1>This is the header of the Home page</h1>
                    <div>
                        {
                            userList.map((userObj,idx) => {
                            return <div key={idx}> <span className= "userName"> {userObj.name}</span> -- {userObj.job}
                            </div>
                            })
                        }
                    </div>
                    <input onChange= {(e) => setName(e.target.value)} type="text" placeholder="Enter name"/>
                    <input onChange= {(e) => setJob(e.target.value)} type="text" placeholder="Enter job"/>

                    <h1>{name}{job}</h1>

                    <div><button onClick={postAPIResponse}>Click to send POST API response</button></div>

                    <div>
                        {(userList && userList.length <= 0 )?<h1>No User Found</h1>:''}
                        {
                            userList && userList.map((userObj,idx) => {
                            return <div key={idx}> {userObj.name} {userObj.job} </div>
                        })
                        }

                    </div>
                <Footer/>
            </div>
        )
}
export default Home;