import '../App.css';
import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { Form, InputGroup, Button } from 'react-bootstrap'
import logo from '../logo.png';



class RegisterComponent extends Component {
  constructor(props) {
    super(props)

    this.state = {

    }
  }

  login() {
    this.props.history.push('/login');
  }


  render() {
    return (
      <div className="register-form">
        <div className="form-register">
          <Form>
            <div className="img-container-register">
              <img src={logo} alt="logo"></img>
            </div>
            <Form.Group controlId="validationFormik101">
              <Form.Label>First Name</Form.Label>
              <InputGroup hasValidation>
                <Form.Control
                  type="text"
                  placeholder="First Name"
                  aria-describedby="inputGroupPrepend"
                  name="firstName"
                />
                <Form.Control.Feedback type="invalid">
                </Form.Control.Feedback>
              </InputGroup>
            </Form.Group>


            <Form.Group controlId="validationFormik102">
              <Form.Label>Last Name</Form.Label>
              <InputGroup hasValidation>
                <Form.Control
                  type="text"
                  placeholder="Last Name"
                  aria-describedby="inputGroupPrepend"
                  name="lastName"
                />
                <Form.Control.Feedback type="invalid">
                </Form.Control.Feedback>
              </InputGroup>
            </Form.Group>


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
              <Button onClick={this.login.bind(this)} className="btn-block" variant="primary" type="submit">
                Register Account
                  </Button>
            </div>

            <div className="text-center pt-3">Already have an account?</div>
            <div className="text-center">
              <a href="" onClick={this.login.bind(this)}>Sign in</a>
            </div>
          </Form>
        </div>
      </div>
    )
  }

}

export default RegisterComponent;
