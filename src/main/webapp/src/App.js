import React,{useEffect} from 'react';
import logo from './logo.svg';
import './App.css';

function App() {

  const [userLogged, setUserLogged] = React.useState({});

  useEffect(() => {

    fetch('/api/user/me')
    .then(res => res.json())
	.then((data) => {
	  setUserLogged(data)
	})
	.catch(console.log);

  },[]);
  
	  
  const getUserName = () => {
    return userLogged.userName;
  }
	
  const isAuthenticated = () => {
    return userLogged != null && userLogged.userName != null;
  }
	  
  const hasRole = (roles) => {
    return userLogged != null && userLogged.roles != null && roles.some(role => userLogged.roles.includes(role));
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        {!isAuthenticated() && <h2>You are not authenticated</h2>}
        {isAuthenticated() && <>
          <h2>Hello {getUserName()}!</h2>
          {hasRole(['user']) && <p>You have the Custom Role, congratulations!</p>}
          {!hasRole(['user']) && <p>You don't have the Custom Role, sorry!</p>}        
          </>}
      </header>
    </div>
  );
}

export default App;
