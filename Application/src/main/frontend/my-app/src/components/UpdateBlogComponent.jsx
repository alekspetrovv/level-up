import React, { Component } from 'react';
import { Button, Form } from "react-bootstrap";
import Nav from "./HeaderComponent";
import BlogService from '../services/BlogServices';

class UpdateStudentComponent extends Component {
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
      this.props.history.push('/blogs');
    });
  }

  cancel() {
    this.props.history.push('/blogs');
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
      <div className="App">
        <Nav />
        <div className="update-blog-form">
          <Form>
            <h3 className="text-center">Update Blog</h3>
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

export default UpdateStudentComponent;