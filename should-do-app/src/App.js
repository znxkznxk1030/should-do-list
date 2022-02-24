import "./App.css";
import ShouldDoList from "./components/ShouldDoList";
import kakaoLoginImg from "./resources/kakao_login_medium_narrow.png";

function App() {

  function onHello() {
    fetch("/api/v1/should-do")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        // setMessage(data);
        console.log(data);
      });
  }

  function onSocialLogin() {
    fetch("/user/profile")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        // setMessage(data);
      });
  }

  return (
    <div className="App">
      <header className="App-header">
        <ShouldDoList></ShouldDoList>
      </header>
    </div>
  );
}

export default App;
