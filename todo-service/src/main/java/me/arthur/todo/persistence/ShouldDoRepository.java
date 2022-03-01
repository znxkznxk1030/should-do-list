package me.arthur.todo.persistence;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ShouldDoRepository extends CrudRepository<ShouldDoEntity, String> {
  List<ShouldDoEntity> findAll();
  @Transactional(readOnly = true)
  List<ShouldDoEntity> findAllByToId(String userId);
  List<ShouldDoEntity> findAllByFromId(String userId);
}
