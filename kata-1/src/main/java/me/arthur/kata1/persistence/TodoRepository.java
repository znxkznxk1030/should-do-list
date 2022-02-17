package me.arthur.kata1.persistence;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, String> {
  
}
