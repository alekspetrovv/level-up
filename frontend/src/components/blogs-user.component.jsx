import React, { Component } from "react";
import { Redirect } from "react-router-dom";
import AuthService from "../services/auth.service";
import BlogService from "../services/blog.service";
class BlogsUser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      content: "",
      blogs: [],
      currentUser: undefined
    };
  }

  componentDidMount() {
    const currentUser = AuthService.getCurrentUser();
    if (!currentUser) this.setState({ redirect: "/login" });
    this.setState({ currentUser: currentUser, userReady: true })
    BlogService.getBlogs().then((res) => {
      this.setState({ blogs: res.data });
    });
  }

  render() {
    if (this.state.redirect) {
      return <Redirect to={this.state.redirect} />
    }
    return (
       <div className="container">
        <div className="post-actions">
          <h2 className="add_post_text">Gaming Articles</h2>
        </div>
        {this.state.blogs.map(
          blog =>
            <div key={blog.id}>
              <header className="jumbotron">
                <div className="blog-item" style={{ position: 'relative' }}>
                  <div className="blog__item__preview">
                    <h3 className="text-center">
                      {blog.title}
                    </h3>
                    <p className="text-center">
                      {blog.body}
                    </p>
                    {/* <img src={"http://localhost:8080" + blog.img}>
                    </img> */}
                  </div>
                </div>
              </header>
            </div>
        )
        }
      </div>
    );
  }
}

export default BlogsUser;