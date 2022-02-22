package me.arthur.clientservice.model;

import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoUser {
  Long id;
  @JsonProperty("has_signed_up")
  Boolean hasSignedUp;
  // @JsonProperty("connected_at")
  // Timestamp connectedAt;
  // @JsonProperty("synched_at")
  // Timestamp synchedAt;
  // String properties;
  // @JsonProperty("kakao_account")
  // String kakaoAccount;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean isHasSignedUp() {
    return this.hasSignedUp;
  }

  public Boolean getHasSignedUp() {
    return this.hasSignedUp;
  }

  public void setHasSignedUp(Boolean hasSignedUp) {
    this.hasSignedUp = hasSignedUp;
  }
}
