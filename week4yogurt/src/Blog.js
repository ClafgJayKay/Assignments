import Footer from "./Footer";
import Header from "./Header";
import { useEffect, useState } from "react";

function Blog() {
  const [blogList, setBlogList] = useState([
    {
      blogTitle: "NEW CHILLS FOR SUMMER",
      content:
        "Blah Blah Blah",
      date: "November 28, 2023",
      username: "Admin",
      img: "images/new-chills.png",
    },

    {
      blogTitle: "BERRIES ON THE GROVE",
      content:
        "ASDF ASDF ASDF ASDF ASDF",
      date: "November 28, 2023",
      username: "Admin",
      img: "images/berries.png",
    },
  ]);
  return (
    <>
      <Header menuname="Blog" />

      <div id="body">
        <div className="header">
          <div>
            <h1>Blog</h1>
          </div>
        </div>
        <div className="blog">
          <div className="featured">
            <ul>
              {blogList.map((obj, index) => {
                return (
                  <li key={index}>
                    <img src={obj.img} alt="" />
                    <div>
                      <h1>{obj.blogTitle}</h1>
                      <span>
                        By {obj.username} on {obj.date}
                      </span>
                      <p>{obj.content}</p>
                      <a href="/SinglePost" className="more">
                        Read More
                      </a>
                    </div>
                  </li>
                );
              })}
            </ul>
            <a href="/Blog" className="load">
              Load More
            </a>
          </div>
          <div className="sidebar">
            <h1>Recent Posts</h1>
            <img src="images/on-diet.png" alt="" />
            <h2>ON THE DIET</h2>
            <span>By Admin on November 28, 2023</span>
            <p>
              LORUM IPSUM TEXT
            </p>
            <a href="/SinglePost" className="more">
              Read More
            </a>
          </div>
        </div>
      </div>

      <Footer />
    </>
  );
}

export default Blog;
