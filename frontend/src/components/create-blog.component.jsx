import React, { Component } from 'react';
import { Button, Form } from "react-bootstrap";
import BlogService from "../services/blog.service";

class CreateBlogComponent extends Component {
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
    this.saveOrUpdateBlog = this.saveOrUpdateBlog.bind(this);
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

  cancel() {
    this.props.history.push('/admin/blogs');
  }

  saveOrUpdateBlog = (event) => {
    event.preventDefault();
    let blog = { title: this.state.title, body: this.state.body, img: this.state.img };
    console.log('blog => ' + JSON.stringify(blog));

    if (this.state.id === '_add') {
      BlogService.createBlog(blog).then(res => {
        this.props.history.push('/admin/blogs');
      });
    } else {
      BlogService.updateBlog(blog, this.state.id).then(res => {
        this.props.history.push('/blogs');
      });
    }
  }

  componentDidMount() {
    if (this.state.id === '_add') {
      return
    } else {
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
  }

  getTitle() {
    if (this.state.id === '_add') {
      return <h3 className="text-center">Create Article</h3>
    } else {
      return <h3 className="text-center">Update Article</h3>
    }
  }




  render() {
    return (
      <div className="col-lg-12">
        <div className="container blog-form">
          <Form.Group>
            <h3 className="text-center">{this.getTitle()}</h3>
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
                onChange={this.changeImageHandler}
                label="Upload Image"
              />
            </Form.Group>
          </Form>
          <Button onClick={this.cancel.bind(this)} variant="primary" type="submit" className="btn btn-danger">
            Cancel
          </Button>
          <Button onClick={this.saveOrUpdateBlog} style={{ float: "right" }} variant="primary" type="submit" className="btn btn-primary">
            Submit
          </Button>
        </div>
      </div>
    )
  }
}

export default CreateBlogComponent