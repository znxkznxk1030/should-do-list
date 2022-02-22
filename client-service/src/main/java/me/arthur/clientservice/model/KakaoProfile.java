package me.arthur.clientservice.model;

public class KakaoProfile {
  String nickName;
  String profileImageURL;
  String thumbnailURL;

  public String getNickName() {
    return this.nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getProfileImageURL() {
    return this.profileImageURL;
  }

  public void setProfileImageURL(String profileImageURL) {
    this.profileImageURL = profileImageURL;
  }

  public String getThumbnailURL() {
    return this.thumbnailURL;
  }

  public void setThumbnailURL(String thumbnailURL) {
    this.thumbnailURL = thumbnailURL;
  }

}
