package me.arthur.clientservice.model;

public class ShouldDo {
  private String userId;
  private String title;
  private String content;

  public ShouldDo(String userId, String title, String content) {
    this.userId = userId;
    this.title = title;
    this.content = content;
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
}
