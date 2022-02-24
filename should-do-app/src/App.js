import "./App.css";

function App() {
  function onHello() {
    fetch("/api/v1/should-do")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        // setMessage(data);
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
        <a href="http://localhost:8080/oauth2/authorization/kakao?redirect_uri=http://localhost:3000/home">
          KaKao
        </a>
        <button onClick={onSocialLogin}>me</button>
        <button onClick={onHello}>Hello</button>
      </header>
      {/* <Route exact path="/" component={SearchParams} /> */}
      {/* <Route path="/details/:id" component={Details} /> */}
    </div>
  );
}

export default App;
