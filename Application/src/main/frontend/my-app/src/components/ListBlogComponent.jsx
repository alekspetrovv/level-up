import React, { Component } from 'react';
import BlogService from '../services/BlogServices';
import Nav from "./HeaderComponent";
import { Button } from "react-bootstrap";
import background from "../background.png"

class ListBlogsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            blogs: []

        }
        this.addBlog = this.addBlog.bind(this);
        this.updateBlog = this.updateBlog.bind(this);
        this.deleteBlog = this.deleteBlog.bind(this);
    }

    componentDidMount() {
        BlogService.getBlogs().then((res) => {
            this.setState({ blogs: res.data });
        });
    }

    addBlog() {
        this.props.history.push('/add-blog/_add');
    }

    updateBlog(id) {
        this.props.history.push('/add-blog/' + id);
    }

    deleteBlog(id) {
        const r = (window.confirm('Are you sure you want to delete this item?'));

        if (r === true) {
            BlogService.deleteBlog(id).then(res => {
                this.setState({ blogs: this.state.blogs.filter(blog => blog.id !== id) });
            });
        }
    }

    render() {
        return (
            <div className="blogs" style={{
                backgroundImage: `url(${background})`
            }}>
                <Nav />
                <div className="container blog-container">
                    <div className="post-actions">
                        <h2 className="add_post_text">Gaming Articles</h2>
                        <Button onClick={this.addBlog} className="btn-add-blog" variant="primary" size="lg" type="submit">
                            Create Blog
                        </Button>
                    </div>
                    {this.state.blogs.map(
                        blog =>
                            <div key={blog.id}>
                                <div className="posts">
                                    <div className="blog-item" style={{ position: 'relative' }}>
                                        <div className="blog__item__preview">
                                            <h3 className="blog_title">
                                                {blog.title}
                                            </h3>
                                            <p className="blog_content">
                                                {blog.body}
                                            </p>
                                        </div>  
                                        {/* <div className="blog__item__img">
                                            <img src={this.state.img} className="blog-image">   
                                            </img>
                                        </div> */}
                                        <div className="btn-actions">
                                        <div className="text-center">
                                            <button type="button" onClick={() => this.updateBlog(blog.id)} className="btn btn-warning">View/Update</button>
                                            <button type="button" className="btn btn-danger" onClick={() => this.deleteBlog(blog.id)}>Delete</button>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    )}
                </div>
            </div>
        )
    }
}

export default ListBlogsComponent