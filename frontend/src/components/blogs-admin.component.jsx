import React, { Component } from "react";
import { Button } from "react-bootstrap";
import { Redirect } from "react-router-dom";
import AuthService from "../services/auth.service";
import BlogService from "../services/blog.service";

class BlogsAdmin extends Component {
  constructor(props) {
    super(props)

    this.state = {
      blogs: [],
      currentUser: undefined
    };
    this.createArticle = this.createArticle.bind(this);
    this.updateArticle = this.updateArticle.bind(this);
    this.deleteArticle = this.deleteArticle.bind(this);
  }


  componentDidMount() {
    const currentUser = AuthService.getCurrentUser();

    if (!currentUser || (currentUser.roles.includes("ROLE_USER"))) this.setState({ redirect: "/login" });
    this.setState({ currentUser: currentUser, userReady: true })

    BlogService.getBlogs().then((res) => {
      this.setState({ blogs: res.data });
    });
  }

  createArticle() {
    this.props.history.push('/add-blog/_add');
  }


  updateArticle(id) {
    this.props.history.push('/add-blog/' + id);
  }




  deleteArticle(id) {
   
    const r = (window.confirm('Are you sure you want to delete this item?'));
    if (r === true) {
      BlogService.deleteBlog(id).then(res => {
        this.setState({ blogs: this.state.blogs.filter(blog => blog.id !== id) });
      });
    }
  }



  render() {
    if (this.state.redirect) {
      return <Redirect to={this.state.redirect} />
    }
    return (
      <div className="container">
        <div className="post-actions">
          <h2 className="add_post_text">Gaming Articles</h2>
          <Button onClick={this.createArticle} className="btn-add-blog ml-auto" variant="primary" size="lg" type="submit">
            Create Article
          </Button>
        </div>
        {this.state.blogs.map(
          blog =>
            <div key={blog.id}>
              <header className="jumbotron">
                <div className="blog-item" style={{ position: 'relative' }}>
                  <div className="blog__item__preview">
                    <div className="btn-actions">
                      <button onClick={()=>{this.updateArticle(blog.id)}} type="button"
                        className="btn btn-warning mr-1">View/Update
                      </button>
                      <button onClick={()=>{ this.deleteArticle(blog.id)} } type="button" className="btn btn-danger"
                      >Delete
                      </button>
                    </div>
                    <h3 className="text-center">
                      {blog.title}
                    </h3>
                    <p className="text-center">
                      {blog.body}
                    </p>
                    <img src={"http://localhost:8080" + blog.img}>
                    </img>
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
export default BlogsAdmin;
