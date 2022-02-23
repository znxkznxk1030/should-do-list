package me.arthur.todo.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ShouldDoRepository extends CrudRepository<ShouldDoEntity, String> {
  List<ShouldDoEntity> findAll();
}
