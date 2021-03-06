package me.arthur.todo.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "todo")
public class ShouldDoEntity extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private int version;

  private String fromId;
  private String toId;
  private String title;
  private String content;
  private Integer state;

  public ShouldDoEntity() {
  }

  public ShouldDoEntity(String fromId, String toId, String title, String content, Integer state) {
    this.fromId = fromId;
    this.toId = toId;
    this.title = title;
    this.content = content;
    this.state = state;
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

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(int version) {
    this.version = version;
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

  public Integer getState() {
    return this.state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  
}
