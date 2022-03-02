import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "./Navigator.css";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faListCheck, faListDots, faUserFriends } from "@fortawesome/free-solid-svg-icons";

const Navigator = () => {
  return (
    <div className="nav">
      <Link to="/">
        <FontAwesomeIcon icon={faListCheck} />
      </Link>
      <Link to="/given">
        <FontAwesomeIcon icon={faListDots} />
      </Link>
      <Link to="/friends">
        <FontAwesomeIcon icon={faUserFriends} />
      </Link>
    </div>
  );
};

export default Navigator;
