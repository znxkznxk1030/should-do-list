import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState([]);

  function onHello() {
    fetch("/hello")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        setMessage(data);
      });
  }
  
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <a href="http://localhost:8080/oauth2/authorization/google">Google</a>
        <a href="http://localhost:8080/oauth2/authorization/kakao">Kakao</a>
        <button onClick={onHello}>Hello</button>
        <ul>
          {" "}
          {message.map((text, index) => (
            <li key={`${index}${text}`}>{text}</li>
          ))}{" "}
        </ul>
      </header>
    </div>
  );
}

export default App;
