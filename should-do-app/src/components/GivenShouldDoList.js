import React, { useState, useEffect } from "react";
import kakaoLoginImg from "../resources/kakao_login_medium_narrow.png";
import "./ShouldDoList.css";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCheck, faSquare } from "@fortawesome/free-solid-svg-icons";

const GivenShouldDoList = () => {
  const [shouldDoList, setShouldDoList] = useState(null);
  const [profile, setProfile] = useState([]);
  const [friendsMap, setFriendsMap] = useState({});

  useEffect(() => {
    fetchGivenShouldDoList();
    fetchSocialLogin();
    fetchFriendsMap();
  }, []);

  function fetchFriendsMap() {
    fetch("/api/v1/user/friends", {
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        // console.log(response);
        return response.json();
      })
      .then(function (friends) {
        // console.log(friends);
        const _friendsMap = {};

        friends.elements.forEach((friend) => {
          // console.log(friend);
          _friendsMap[friend.id] = friend;
        });

        setFriendsMap(_friendsMap);
      });
  }

  function fetchGivenShouldDoList() {
    fetch("/api/v1/should-do/given")
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
        <h1>'s Given Should-Do List</h1>
      </div>

      <div className="should-do-list">
        {shouldDoList.map((item, index) => (
          <div key={index}>
            <div className="item__data">
              <div className="item__status item_given">
                <ShouldDoItemStatus state={item.state} />
              </div>
              <div className="item__names item_given">{item.title}</div>
              <div className="item__friend">
                <h4>by&nbsp;&nbsp;d</h4>
                <img
                  src={friendsMap[item.toId]?.profile_thumbnail_image}
                  alt="profile_image"
                />
              </div>
              <div className="item__bar item__bar_given"></div>
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
      return <div></div>;
    case 1:
      return <FontAwesomeIcon icon={faCheck} />;
    case 2:
      return <FontAwesomeIcon icon={faSquare} />;
    default:
      return <FontAwesomeIcon className="item__wait" icon={faSquare} />;
  }
}

export default GivenShouldDoList;
