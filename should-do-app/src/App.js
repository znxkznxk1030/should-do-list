import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState([]);

  useEffect(() => {
    fetch("/hello")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        setMessage(data);
      });
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <a href="/oauth2/authorization/google">Google</a>
        <a href="/oauth2/authorization/kakao">Kakao</a>
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
