import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import background from "./background.png"
import AuthService from "./services/auth.service";
import logo from './logo-nav.png';
import Login from "./components/login.component.jsx";
import Register from "./components/register.component.jsx";
import Profile from "./components/profile.component.jsx";
import BlogsUser from "./components/blogs-user.component.jsx";
import BlogsAdmin from "./components/blogs-admin.component.jsx";
import CreateBlog from "./components/create-blog.component.jsx";

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      id: undefined,
      showAdminBoard: false,
      showUserBoard: false,
      currentUser: undefined,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();
    if (user) {
      this.setState({
        currentUser: user,
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
        showUserBoard: user.roles.includes("ROLE_USER"),
      });
    }
  }

  logOut() {
    AuthService.logout();
  }

  render() {
    const { currentUser, showAdminBoard, showUserBoard } = this.state;

    return (
      <div className="home-page" style={{
        backgroundImage: `url(${background})`
      }}>
        <nav className="navbar navbar-expand navbar-dark bg-primary">
          <Link className="navbar-brand">
            <img className="logo-nav" src={logo} alt="logo"></img>
          </Link>
          <div className="navbar-nav mr-auto">

            {showUserBoard && (
              <li className="nav-item">
                <Link to={"/user/blogs"} className="nav-link">
                  Blogs
                </Link>
              </li>
            )}


            {showAdminBoard && (
              <li className="nav-item">
                <Link to={"/admin/blogs"} className="nav-link">
                  Blogs
                </Link>
              </li>
            )}
          </div>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/profile"} className="nav-link">
                  Profile
                </Link>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  Logout
                </a>
              </li>
            </div>
          ) : (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                  Login
                </Link>
              </li>

              <li className="nav-item">
                <Link to={"/register"} className="nav-link">
                  Sign Up
                </Link>
              </li>
            </div>
          )}
        </nav>

        <div className="container mt-5">
          <Switch>
          <Route exact path="/" component={Login}/>
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />
            <Route exact path="/profile" component={Profile} />
            <Route path="/user/blogs" component={BlogsUser} />
            <Route path="/admin/blogs" component={BlogsAdmin} />
            <Route path="/add-blog/:id" exact component={CreateBlog}></Route>
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
