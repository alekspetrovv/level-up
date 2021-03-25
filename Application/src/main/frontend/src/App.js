import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import axios from "axios";


const UserProfiles = () => {
   
  const [userProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/user/all").then(res => {
      console.log(res);
      setUserProfiles(res.data);
    });
  };

  useEffect(() =>{
    fetchUserProfiles();
  },[]);
  
  return userProfiles.map((userProfile,index) => {

    return(
      <div key={index}>
        <h1>{userProfile.email}</h1>
        <p>{userProfile.id}</p>
      </div>
    )
  })
};


function App() {
  return (
    <div className="App">
      <UserProfiles />
    </div>
  );
}

export default App;
