package me.arthur.todo.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "todo")
public class TodoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private int version;

  private String title;
  private String content;


  public TodoEntity() {
  }


  public TodoEntity(String title, String content) {
    this.title = title;
    this.content = content;
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
  
}
