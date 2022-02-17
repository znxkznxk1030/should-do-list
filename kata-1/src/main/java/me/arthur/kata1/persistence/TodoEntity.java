package me.arthur.kata1.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "todo")
public class TodoEntity {
  @Id
  @GeneratedValue
  private int id;

  @Version
  private int version;
}
