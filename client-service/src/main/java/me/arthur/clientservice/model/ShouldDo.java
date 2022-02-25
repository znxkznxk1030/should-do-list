package me.arthur.clientservice.model;

public class ShouldDo {
  private String userId;
  private String title;
  private String content;
  private String createdDate;
  private String modifiedDate;
  private Integer state;


  public ShouldDo() {
  }


  public ShouldDo(String userId, String title, String content, String createdDate, String modifiedDate) {
    this.userId = userId;
    this.title = title;
    this.content = content;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getModifiedDate() {
    return this.modifiedDate;
  }

  public void setModifiedDate(String modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public Integer getState() {
    return this.state;
  }

  public void setState(Integer state) {
    this.state = state;
  }


}