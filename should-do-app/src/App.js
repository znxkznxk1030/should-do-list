import "./App.css";
import ShouldDoList from "./components/ShouldDoList";

import { Route, Routes, Link } from "react-router-dom";
import FriendsList from "./components/FriendsList";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/friends">Friends</Link>
          </li>
        </ul>
        <Routes>
          <Route path="/" element={<ShouldDoList />} />
          <Route path="/friends" element={<FriendsList />} />
        </Routes>
      </header>
    </div>
  );
}

export default App;
