import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Nav from './HeaderComponent';
import { Form, InputGroup, Button } from 'react-bootstrap'


class SettingsComponent extends Component {
  constructor(props) {
    super(props)

    this.state = {

    }


  }

  cancel() {
    this.props.history.push('/blogs');
  }

  render() {
    return (
      <div >
        <Nav />
        <div className="update-form">
          <Form>

            <div className="text-header">
              <h3 className="text-center">Settings Page</h3>
            </div>
            <br></br>
            <p>If you wish to update your profile settings please enter the necessary information!</p>
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

            <Button onClick={this.cancel.bind(this)} variant="primary" type="submit" className="btn btn-danger">
              Cancel
              </Button>

            <Button style={{ float: "right" }} variant="primary" type="submit" className="btn btn-primary">
              Submit
              </Button>
          </Form>
        </div>
      </div>
    )
  }
}

export default SettingsComponent