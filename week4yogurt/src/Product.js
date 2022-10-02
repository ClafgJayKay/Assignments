import Footer from "./Footer";
import Header from "./Header";
import {useState } from 'react';

function Product(){

    const [classicList,setClassicList] = useState([
        {"name":"Kiwi","img":"images/kiwi.jpg"},
        {"name":"Mango","img":"images/mango.jpg"},
        {"name":"Cantaloupe","img":"images/cantaloupe.jpg"}
    ]);

    const [berryList,setBerryList] = useState([
        {"name":"blackberry","img":"images/blackberry.jpg"},
        {"name":"Strawberry","img":"images/strawberry.jpg"},
        {"name":"BLUEBERRY","img":"images/blueberry.jpg"}
    ]);

    const [fruitList,setFruitList] = useState([
        {"name":"Grapes","img":"images/grapes.jpg"},
        {"name":"Green Apple","img":"images/green-apple.jpg"},
        {"name":"pineapple","img":"images/pineapple.jpg"}
    ]);

    return(
        <>
            <Header menuname="Product"/>

            <div id="body">
                <div className="header">
                    <div>
                        <h1>Products</h1>
                    </div>
                </div>
                <div>
                    <ul>
                        <li>
                            <h1>All Time Classic</h1>
                            <p>This website template has been designed by freewebsitetemplates.com for you, for free.</p>
                        </li>

                        {

                            classicList.map((obj,index)=>{
                                return(

                                    <li key={index}>
                                        <img src={obj.img} alt=""/>
                                        <h2>{obj.name}</h2>
                                    </li>
                                )
                            })
                        }
                        
                    </ul>
                    <ul>
                        <li>
                            <h1>Berry Special</h1>
                            <p>This website template has been designed by freewebsitetemplates.com for you, for free.</p>
                        </li>

                        {

                            berryList.map((obj,index)=>{
                                return(

                                    <li key={index}>
                                        <img src={obj.img} alt=""/>
                                        <h2>{obj.name}</h2>
                                    </li>
                                )
                            })                   
                        }

                    </ul>
                    <ul>
                        <li>
                            <h1>Fruit Blast</h1>
                            <p>This website template has been designed by freewebsitetemplates.com for you, for free.</p>
                        </li>

                        {

                            fruitList.map((obj,index)=>{
                                return(

                                    <li key={index}>
                                        <img src={obj.img} alt=""/>
                                        <h2>{obj.name}</h2>
                                    </li>
                                )
                            })                   
                        }


                    </ul>
                </div>
		    </div>

            <Footer/>
       </>
    )
}
export default Product;