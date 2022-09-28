import Footer from "./Footer";
import Header from "./Header";
import {useEffect, useState} from "react";

function Home() {
  const[glasslist,setGlassList] = useState([{"name":"glasses", "price":60}]);
  const[userList,setUserList] = useState([]);

  const[name,setName] = useState();
  const[phonenumber, setPhoneNumber] = useState();
  const[email,setEmail] = useState();
  const[message,setMessage] = useState();

  const getApiResponse=(pageNo)=>{
    fetch("https://reqres.in/api/users?page=" +pageNo)
    .then(res=>res.json())
    .then(res2=>{
      setUserList(res2['data']);
    })
  }

  useEffect(()=>getApiResponse(1),[])

  const btn_click=()=>{
        if(name == "" || name == undefined){
            alert("please fill in all blanks");
        }
        else if(phonenumber == "" || phonenumber == undefined){
            alert("please fill in all blanks");
        }
        else if(email == "" || email == undefined){
          alert("please fill in all blanks");
        }
        else if(message == "" || message == undefined){
          alert("please fill in all blanks");
        }
        else{
          alert("everything is in order")
        }
      }
  return (
    <>
      <Header menuname="home" />

      <div>
        <section className="banner_main">
          <div id="banner1" className="carousel slide" data-ride="carousel">
            <ol className="carousel-indicators">
              <li data-target="#banner1" data-slide-to={0} className="active" />
              <li data-target="#banner1" data-slide-to={1} />
              <li data-target="#banner1" data-slide-to={2} />
            </ol>
            <div className="carousel-inner">
              <div className="carousel-item active">
                <div className="container">
                  <div className="carousel-caption">
                    <div className="text-bg">
                      <h1>
                        {" "}
                        <span className="blu">
                          Welcome <br />
                        </span>
                        To Our Sunglasses
                      </h1>
                      <figure>
                        <img src="images/banner_img.png" alt="#" />
                      </figure>
                      <a className="read_more" href="#">
                        Shop Now
                      </a>
                    </div>
                  </div>
                </div>
              </div>
              <div className="carousel-item">
                <div className="container">
                  <div className="carousel-caption">
                    <div className="text-bg">
                      <h1>
                        {" "}
                        <span className="blu">
                          Welcome <br />
                        </span>
                        To Our Sunglasses
                      </h1>
                      <figure>
                        <img src="images/banner_img.png" alt="#" />
                      </figure>
                      <a className="read_more" href="#">
                        Shop Now
                      </a>
                    </div>
                  </div>
                </div>
              </div>
              <div className="carousel-item">
                <div className="container">
                  <div className="carousel-caption">
                    <div className="text-bg">
                      <h1>
                        {" "}
                        <span className="blu">
                          Welcome <br />
                        </span>
                        To Our Sunglasses
                      </h1>
                      <figure>
                        <img src="images/banner_img.png" alt="#" />
                      </figure>
                      <a className="read_more" href="#">
                        Shop Now
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <a
              className="carousel-control-prev"
              href="#banner1"
              role="button"
              data-slide="prev"
            >
              <i className="fa fa-arrow-left" aria-hidden="true" />
            </a>
            <a
              className="carousel-control-next"
              href="#banner1"
              role="button"
              data-slide="next"
            >
              <i className="fa fa-arrow-right" aria-hidden="true" />
            </a>
          </div>
        </section>
        {/* end banner */}
        {/* about section */}
        <div className="about">
          <div className="container">
            <div className="row d_flex">
              <div className="col-md-5">
                <div className="about_img">
                  <figure>
                    <img src="images/about_img.png" alt="#" />
                  </figure>
                </div>
              </div>
              <div className="col-md-7">
                <div className="titlepage">
                  <h2>About Our Shop</h2>
                  <p>
                    There are many variations of passages of Lorem Ipsum
                    available, but the majority have suffered alteration in some
                    form, by injected humour, or randomised words which don't
                    look even slightly believable. If you are going to use a
                    passage of Lorem Ipsum, you need to be sure there isn't
                    anything embarrassing hidden in the middle of text.
                  </p>
                </div>
                <a className="read_more" href="#">
                  Read More
                </a>
              </div>
            </div>
          </div>
        </div>
        {/* about section */}
        {/* Our  Glasses section */}
        <div className="glasses">
          <div className="container">
            <div className="row">
              <div className="col-md-10 offset-md-1">
                <div className="titlepage">
                  <h2>Our Glasses</h2>
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                    do eiusmod tempor incididunt ut labor e et dolore magna
                    aliqua. Ut enim ad minim veniam, qui
                  </p>
                </div>
              </div>
            </div>
          </div>
          <div className="container-fluid">
            <div className="row">
              {/*         
        {
          glasslist.map((obj,index)=>{
            return(
              <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6">
              <div className="glasses_box">
                <figure><img src="images/glass1.png" alt="#" /></figure>
                <h3><span className="blu">$</span>{obj.price}</h3>
                <p>{obj.name}</p>
              </div>
            </div>
          )
          })
        } */}
              <select onChange={(e) => getApiResponse(e.target.value)}>
                <option value="1">Page 1</option>
                <option value="2">Page 2</option>
                <option value="3">Page 3</option>
              </select>
              {userList.map((obj, index) => {
                return (
                  <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6">
                    <div className="glasses_box">
                      <figure>
                        <img src={obj.avatar} alt="#" />
                      </figure>
                      <h3>
                        <span className="blu"></span>
                        {obj.first_name}
                      </h3>
                      <p>{obj.email}</p>
                    </div>
                  </div>
                );
              })}

              <div>
                {userList && userList.length <= 0 ? <h1>No User Found</h1> : ""}
              </div>

              <div className="col-md-12">
                <a className="read_more" href="#">
                  Read More
                </a>
              </div>
            </div>
          </div>
        </div>
        {/* end Our  Glasses section */}
        {/* Our shop section */}
        <div id="about" className="shop">
          <div className="container-fluid">
            <div className="row">
              <div className="col-md-5">
                <div className="shop_img">
                  <figure>
                    <img src="images/shop_img.png" alt="#" />
                  </figure>
                </div>
              </div>
              <div className="col-md-7 padding_right0">
                <div className="max_width">
                  <div className="titlepage">
                    <h2>Best SunGlasses At Our shop</h2>
                    <p>
                      Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                      sed do eiusmod tempor incididunt ut labore et dolore magna
                      aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                      ullamco laboris nisi ut aliquip ex ea commodo consequat.
                      Duis aute irure dolor in reprehenderit in voluptate velit
                      esse cillum dolore
                    </p>
                    <a className="read_more" href="#">
                      Shop Now
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        {/* end Our shop section */}
        {/* clients section */}
        <div className="clients">
          <div className="container">
            <div className="row">
              <div className="col-md-12">
                <div className="titlepage">
                  <h2>What say our clients</h2>
                  <p>
                    orem ipsum dolor sit amet, consectetur adipiscing elit, sed
                    do eiusmod tempor incididunt ut la
                  </p>
                </div>
              </div>
            </div>
            <div className="row">
              <div className="col-md-12">
                <div
                  id="myCarousel"
                  className="carousel slide clients_Carousel "
                  data-ride="carousel"
                >
                  <ol className="carousel-indicators">
                    <li
                      data-target="#myCarousel"
                      data-slide-to={0}
                      className="active"
                    />
                    <li data-target="#myCarousel" data-slide-to={1} />
                    <li data-target="#myCarousel" data-slide-to={2} />
                  </ol>
                  <div className="carousel-inner">
                    <div className="carousel-item active">
                      <div className="container">
                        <div className="carousel-caption ">
                          <div className="row">
                            <div className="col-md-12">
                              <div className="clients_box">
                                <figure>
                                  <img src="images/our.png" alt="#" />
                                </figure>
                                <h3>Sandy Mark</h3>
                                <p>
                                  It is a long established fact that a reader
                                  will be distracted by the readable content of
                                  a page when looking at its layout. The point
                                  of using Lorem Ipsum is that it has a
                                  more-or-less normal distribution of letters,It
                                  is a long established fact a more-or-less
                                  normal distribution of letters,
                                </p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div className="carousel-item">
                      <div className="container">
                        <div className="carousel-caption">
                          <div className="row">
                            <div className="col-md-12">
                              <div className="clients_box">
                                <figure>
                                  <img src="images/our.png" alt="#" />
                                </figure>
                                <h3>Sandy Mark</h3>
                                <p>
                                  It is a long established fact that a reader
                                  will be distracted by the readable content of
                                  a page when looking at its layout. The point
                                  of using Lorem Ipsum is that it has a
                                  more-or-less normal distribution of letters,It
                                  is a long established fact a more-or-less
                                  normal distribution of letters,
                                </p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div className="carousel-item">
                      <div className="container">
                        <div className="carousel-caption">
                          <div className="row">
                            <div className="col-md-12">
                              <div className="clients_box">
                                <figure>
                                  <img src="images/our.png" alt="#" />
                                </figure>
                                <h3>Sandy Mark</h3>
                                <p>
                                  It is a long established fact that a reader
                                  will be distracted by the readable content of
                                  a page when looking at its layout. The point
                                  of using Lorem Ipsum is that it has a
                                  more-or-less normal distribution of letters,It
                                  is a long established fact a more-or-less
                                  normal distribution of letters,
                                </p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <a
                    className="carousel-control-prev"
                    href="#myCarousel"
                    role="button"
                    data-slide="prev"
                  >
                    <i className="fa fa-angle-left" />
                  </a>
                  <a
                    className="carousel-control-next"
                    href="#myCarousel"
                    role="button"
                    data-slide="next"
                  >
                    <i className="fa fa-angle-right" />
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
        {/* end clients section */}
        {/* contact section */}
        <div id="contact" className="contact">
          <div className="container">
            <div className="row">
              <div className="col-md-6">
                <form id="request" className="main_form">
                  <div className="row">
                    <div className="col-md-12 ">
                      <h3>Contact Us</h3>
                    </div>
                    <div className="col-md-12 ">
                      <input
                        onChange={(e) => setName(e.target.value)}
                        type="type"
                        placeholder="Name"
                      />
                    </div>
                    <div className="col-md-12">
                      <input
                        onChange={(e) => setPhoneNumber(e.target.value)}
                        type="type"
                        placeholder="Phone Number"
                      />
                    </div>
                    <div className="col-md-12">
                      <input
                        onChange={(e) => setEmail(e.target.value)}
                        type="type"
                        placeholder="Email"
                      />
                    </div>
                    <div className="col-md-12">
                      <input
                        onChange={(e) => setMessage(e.target.value)}
                        type="type"
                        placeholder="Message"
                      />
                    </div>
                    <div className="col-md-12">
                      <button onClick={btn_click} className="send_btn">
                        Send
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div className="container-fluid">
            <div className="map_section">
              <div id="map"></div>
            </div>
          </div>
        </div>
      </div>

      <Footer />
    </>
  );
}

export default Home;
