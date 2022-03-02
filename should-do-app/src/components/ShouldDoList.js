import React, { useState, useEffect } from "react";
import kakaoLoginImg from "../resources/kakao_login_medium_narrow.png";
import "./ShouldDoList.css";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faCheck,
  faHourglass,
  faPause,
  faSquare,
  faStop,
} from "@fortawesome/free-solid-svg-icons";

const ShouldDoList = () => {
  const [shouldDoList, setShouldDoList] = useState(null);
  const [profile, setProfile] = useState([]);

  useEffect(() => {
    fetchShouldDoList();
    fetchSocialLogin();
  }, []);

  function fetchShouldDoList() {
    fetch("/api/v1/should-do")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        setShouldDoList(data.response);
      });
  }

  function fetchSocialLogin() {
    fetch("/api/v1/user/profile")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        setProfile(data);
      });
  }

  function onChangeStatus(item) {
    item.state = (item.state + 1) % 3;
    fetch("/api/v1/should-do", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(item),
    })
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        fetchShouldDoList();
      });
  }

  if (!shouldDoList) {
    return (
      <div>
        <a href="http://localhost:8080/oauth2/authorization/kakao?redirect_uri=http://localhost:3000/home">
          <img alt="Kakao Login" src={kakaoLoginImg} />
        </a>
      </div>
    );
  }

  return (
    <div className="should-do-wrapper">
      <div className="should-do-header">
        <img src={profile.thumbnailURL} alt="profile_image" />
        <h1>'s Should-Do List</h1>
      </div>

      <div className="should-do-list">
        {shouldDoList.map((item, index) => (
          <div key={index}>
            <div className="item__data">
              <div className="item__status" onClick={(e) => onChangeStatus(item)}>
                <ShouldDoItemStatus state={item.state} />
              </div>
              <div className="item__names">{item.title}</div>
              <div className="item__btn_detail">
                {/* <FontAwesomeIcon icon={faChevronDown} /> */}
              </div>
              <div className="item__bar"></div>
            </div>
            {/* <div className="item__detail">{item.content}</div> */}
          </div>
        ))}
      </div>
    </div>
  );
};

function ShouldDoItemStatus(props) {
  switch (props.state) {
    case 0:
      return <div></div>
    case 1:
      return <FontAwesomeIcon icon={faCheck} />;
    case 2:
      return <FontAwesomeIcon icon={faSquare} />;
    default:
      return <FontAwesomeIcon className="item__wait" icon={faSquare} />;
  }
}

export default ShouldDoList;
