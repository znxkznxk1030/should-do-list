package me.arthur.todo.service;

import java.time.LocalDateTime;

public class ShouldDo {
  private Long id;
  private String fromId;
  private String toId;
  private String title;
  private String content;
  private Integer state;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;

  public ShouldDo() {
  }

  public ShouldDo(
      Long id, String fromId, String toId, String title, String content, Integer state, LocalDateTime createdDate,
      LocalDateTime modifiedDate) {
    this.id = id;
    this.fromId = fromId;
    this.toId = toId;
    this.title = title;
    this.content = content;
    this.state = state;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
  }


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public LocalDateTime getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDateTime getModifiedDate() {
    return this.modifiedDate;
  }

  public void setModifiedDate(LocalDateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public Integer getState() {
    return this.state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

}
