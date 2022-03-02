import React, { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom";

import "./ShouldDoForm.css";

import kakaoLoginImg from "../resources/kakao_login_medium_narrow.png";

const ShouldDoForm = (props) => {
  const [toUser, setToUser] = useState(null);
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const location = useLocation();
  const navigate = useNavigate();

  useEffect(() => {
    setToUser(location.state?.toUser);
  }, [location.state?.toUser, location.state.user]);

  function handleSubmit(event) {
    event.preventDefault();
    // alert(`${title} : ${content}`);
    onCreateShouldDo();
  }

  function onCreateShouldDo() {
    const shouldDo = {
      toId: toUser.id,
      title,
      content: "",
      state: 0,
    };

    fetch("/api/v1/should-do", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(shouldDo),
    })
      .then((response) => {
        return response.json();
      })
      .then(function (data) {
        navigate("../", { replace: true });
      });
  }

  if (!toUser) {
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
        <img src={toUser.profile_thumbnail_image} alt="profile_image" />
        <h1>&nbsp;Should Do...&nbsp;</h1>
      </div>
      <form className="should-do_form" onSubmit={handleSubmit}>
        <input
          className="title_input"
          type="text"
          placeholder={`A Thing ${toUser?.profile_nickname} Should Do`}
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        {/* <input
          type="text"
          placeholder="More Detail"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        /> */}
        <input type="submit" value="+" className="submit_input"></input>
      </form>
    </div>
  );
};

export default ShouldDoForm;
