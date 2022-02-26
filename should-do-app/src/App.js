import "./App.css";
import ShouldDoList from "./components/ShouldDoList";

import { Route, Routes, Link } from "react-router-dom";
import FriendsList from "./components/FriendsList";

function App() {
  return (
    <div className="App">
      <div className="App-body">
        <div>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/friends">Friends</Link>
            </li>
          </ul>
        </div>
        <Routes>
          <Route path="/" element={<ShouldDoList />} />
          <Route path="/friends" element={<FriendsList />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
