package me.arthur.todo.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, String> {
  List<TodoEntity> findAll();
}
