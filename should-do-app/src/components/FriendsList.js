import React, { useState, useEffect } from "react";

import kakaoLoginImg from "../resources/kakao_login_medium_narrow.png";
import "./ShouldDoList.css";

const FriendsList = () => {
  const [friendsList, setFriendsList] = useState(null);
  const [profile, setProfile] = useState([]);

  useEffect(() => {
    fetchFriendsList();
    fetchSocialLogin();
  }, []);

  function fetchFriendsList() {
    fetch("/user/friends", {
      headers: {
        "Content-Type": "application/json",
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
    })
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then(function (data) {
        console.log(data);
        setFriendsList(data.elements);
      });
  }

  function fetchSocialLogin() {
    fetch("/user/profile")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        // console.log(data);
        setProfile(data);
      });
  }

  if (!friendsList) {
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
        <h1>'s Kakao Friends</h1>
      </div>
      {friendsList.map((item, index) => (
        <div className="item__data" key={index}>
          {/* <div>{item.title}</div> */}
          <div className="item__thumbnail">
            <img src={item.profile_thumbnail_image} alt="profile_image" />
          </div>
          <div className="item__names">{item.profile_nickname}</div>
          <div className="item__names"></div>
          <div className="item__bar"></div>
        </div>
      ))}
    </div>
  );
};

export default FriendsList;
