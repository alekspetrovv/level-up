import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import SettingsComponent from './components/SettingsComponent';
import RegisterComponent from './components/RegisterComponent';
import LoginComponent from './components/LoginComponent';
import ListBlogComponent from "./components/ListBlogComponent";
import CreateBlogComponent from "./components/CreateBlogComponent";

function App() {
    return (
        <Router>
            <div>
                <Switch>
                    <Route path="/" exact component={LoginComponent} />
                    <Route path="/blogs" exact component={ListBlogComponent} />
                    <Route path="/settings" component={SettingsComponent} />
                    <Route path="/register" component={RegisterComponent} />
                    <Route path="/login" exact component={LoginComponent} />
                    <Route path="/add-blog/:id" exact component={CreateBlogComponent}></Route>
                </Switch>
            </div>
        </Router>
    );
}
export default App;
