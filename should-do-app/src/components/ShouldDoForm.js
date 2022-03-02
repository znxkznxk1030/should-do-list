import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import "./ShouldDoForm.css"

import kakaoLoginImg from "../resources/kakao_login_medium_narrow.png";

const ShouldDoForm = (props) => {
  const [profile, setProfile] = useState(null);
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const navigate = useNavigate();

  useEffect(() => {
    fetchSocialLogin();
  }, []);

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

  function handleSubmit(event) {
    event.preventDefault();
    alert(`${title} : ${content}`);
    navigate("../", { replace: true });
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
        <h1>&nbsp;Should Do...&nbsp;</h1>
      </div>
      <form className="should-do_form" onSubmit={handleSubmit}>
        <input
          className="title_input"
          type="text"
          placeholder="A Thing Should Do"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        {/* <input
          type="text"
          placeholder="More Detail"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        /> */}
        <input type="submit" value="+" className="submit_input">
        </input>
      </form>
    </div>
  );
};

export default ShouldDoForm;
