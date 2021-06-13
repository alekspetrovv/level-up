import React, { Component } from 'react';
import { Button, Form } from "react-bootstrap";
import BlogService from '../services/BlogServices';

class UpdateBlogComponent extends Component {
  constructor(props) {
    super(props)
    
    this.state = {
      id: this.props.match.params.id,
      title: '',  
      body: '',
      img: undefined
    }

    this.changeTitleHandler = this.changeTitleHandler.bind(this);
    this.changeBodyHandler = this.changeBodyHandler.bind(this);
    this.changeImageHandler = this.changeImageHandler.bind(this);
    this.updateBlog = this.updateBlog.bind(this);
  }

  changeTitleHandler = (event) => {
    this.setState({ title: event.target.value });
  }

  changeBodyHandler = (event) => {
    this.setState({ body: event.target.value });
  }

  changeImageHandler = (event) => {
    this.setState({ img: event.target.files[0] });
  }

  updateBlog = (event) => {
    event.preventDefault();
    let blog = { title: this.state.title, body: this.state.body, img: this.state.img };
    BlogService.updateBlog(blog, this.state.id).then(res => {
      this.props.history.push('/admin/blogs');  
    });
  }

  cancel() {
    this.props.history.push('/admin/blogs');
  }

  componentDidMount() {
    BlogService.getBlogById(this.state.id).then((res) => {
      let blog = res.data;
      console.log(blog);
      this.setState({
        title: blog.title,
        body: blog.body,
        img: blog.img
      });
    });
  }

  render() {
    return (
      <div className="col-lg-12">
        <div className="container">
          <Form>
            <h3 className="text-center">Update Article</h3>
            <Form.Group>
              <Form.Label>Title</Form.Label>
              <Form.Control
                value={this.state.title}
                onChange={this.changeTitleHandler}
              />
            </Form.Group>
            <Form.Group >
              <Form.Label>Body</Form.Label>
              <Form.Control
                as="textarea"
                rows={5}
                type="text"
                required
                id="body"
                value={this.state.body}
                onChange={this.changeBodyHandler}
                name="body" />
            </Form.Group>
            <Form>
              <Form.Group>
                <Form.File
                  value={this.state.file}
                  onChange={this.changeImageHandler}
                  label="Upload Image"
                />
              </Form.Group>
            </Form>
            <Button onClick={this.cancel.bind(this)} variant="primary" type="submit" className="btn btn-danger">
              Cancel
            </Button>
            <Button onClick={this.updateBlog} style={{ float: "right" }} variant="primary" type="submit" className="btn btn-primary">
              Submit
            </Button>
          </Form>
        </div>
      </div>
    );
  }
}

export default UpdateBlogComponent;