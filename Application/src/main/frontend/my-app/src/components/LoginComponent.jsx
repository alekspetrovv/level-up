import React, { Component } from 'react';
import { Form, Button, InputGroup } from 'react-bootstrap';
import logo from '../logo.png';

class LoginComponent extends Component {
  constructor(props) {
    super(props)

    this.state = {

    }
  }


  login() {
    this.props.history.push('/blogs');
  }

  register() {
    this.props.history.push('/register');
  }

  render() {
    return (
      <div className="login-form">
        <div className="form-login">
          <div className="img-container">
            <img src={logo} alt="logo"></img>
          </div>
          <Form.Group controlId="validationFormik103">
            <Form.Label>Email</Form.Label>
            <InputGroup hasValidation>
              <InputGroup.Prepend>
                <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text>
              </InputGroup.Prepend>

              <Form.Control
                type="text"
                placeholder="Email"
                aria-describedby="inputGroupPrepend"
                name="email"

              />
              <Form.Control.Feedback type="invalid">
              </Form.Control.Feedback>
            </InputGroup>
            <Form.Text className="text-muted">
              We'll never share your email with anyone else.
          </Form.Text>
          </Form.Group>
          <Form.Group controlId="validationFormik104">
            <Form.Label>Password</Form.Label>
            <InputGroup hasValidation>
              <Form.Control
                type="password"
                placeholder="Password"
                aria-describedby="inputGroupPrepend"
                name="password"
              />
              <Form.Control.Feedback type="invalid">
              </Form.Control.Feedback>
            </InputGroup>
          </Form.Group>

          <div className="btn-register">
            <Button onClick= {this.login.bind(this)}className="btn-block" variant="primary" type="submit">
              Sign in
             </Button>
          </div>

          <div className="text-center pt-3">Don't have an account?</div>
          <div className="text-center">
            <a href="" onClick={this.register.bind(this)}>Sign up</a>
          </div>
        </div>
      </div>
    )
  }
}

export default LoginComponent
