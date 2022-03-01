package me.arthur.clientservice.model;

public class ShouldDo {
  private String fromId;
  private String toId;
  private String title;
  private String content;
  private String createdDate;
  private String modifiedDate;
  private Integer state;

  public ShouldDo() {
  }

  public ShouldDo(String fromId, String toId, String title, String content, String createdDate, String modifiedDate) {
    this.fromId = fromId;
    this.toId = toId;
    this.title = title;
    this.content = content;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
  }


  public String getFromId() {
    return this.fromId;
  }

  public void setFromId(String fromId) {
    this.fromId = fromId;
  }

  public String getToId() {
    return this.toId;
  }

  public void setToId(String toId) {
    this.toId = toId;
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