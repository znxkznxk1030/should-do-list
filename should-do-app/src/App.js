import "./App.css";
import ShouldDoList from "./components/ShouldDoList";

import { Route, Routes, Link } from "react-router-dom";
import FriendsList from "./components/FriendsList";
import Navigator from "./components/Navigator";
import ShouldDoForm from "./components/ShouldDoForm";

function App() {
  return (
    <div className="App">
      <div className="App-body">
        <Navigator />
        <Routes>
          <Route path="/" element={<ShouldDoList />} />
          <Route path="/friends" element={<FriendsList />} />
          <Route path="/form" element={<ShouldDoForm />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
