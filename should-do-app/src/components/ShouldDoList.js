import React, { useState, useEffect } from "react";
import kakaoLoginImg from "../resources/kakao_login_medium_narrow.png";
import "./ShouldDoList.css";

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
        // setMessage(data);
        console.log(data);
        setShouldDoList(data.response);
      });
  }

  function fetchSocialLogin() {
    fetch("/user/profile")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        console.log(data);
        setProfile(data);
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
    <div className="should-do-list">
      <div className="should-do-header">
        <img src={profile.thumbnailURL} alt="profile_image" />
        <h1>'s Should-Do List</h1>
      </div>

      {shouldDoList.map((item, index) => (
        <div className="item__data" key={index}>
          {/* <div>{item.title}</div> */}
          <div className="item__names">{item.content}</div>
          <div className="item__bar"></div>
        </div>
      ))}
    </div>
  );
};

export default ShouldDoList;
