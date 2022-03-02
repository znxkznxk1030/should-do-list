import React, { useState, useEffect } from "react";

import kakaoLoginImg from "../resources/kakao_login_medium_narrow.png";
import "./ShouldDoList.css";

import { Link } from "react-router-dom";

const FriendsList = () => {
  const [friendsList, setFriendsList] = useState([]);
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    fetchFriendsList();
    fetchSocialLogin();
  }, []);

  function fetchFriendsList() {
    fetch("/api/v1/user/friends", {
      headers: {
        "Content-Type": "application/json",
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
    fetch("/api/v1/user/profile")
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        // console.log(data);
        setProfile(data);
      });
  }

  if (!profile) {
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
      {friendsList.map((user, index) => (
        <Link
          key={index}
          to="/form"
          state={{ toUser: user}}
        >
          <div className="item__data">
            {/* <div>{item.title}</div> */}
            <div className="item__thumbnail">
              <img src={user.profile_thumbnail_image} alt="profile_image" />
            </div>
            <div className="item__names">{user.profile_nickname}</div>
            <div className="item__names"></div>
            <div className="item__bar"></div>
          </div>
        </Link>
      ))}
    </div>
  );
};

export default FriendsList;
