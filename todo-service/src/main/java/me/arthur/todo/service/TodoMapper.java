package me.arthur.todo.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import me.arthur.todo.persistence.TodoEntity;

@Mapper(componentModel = "spring")
public interface TodoMapper {

  Todo entityToApi(TodoEntity entity);

  // Java 8 and later
  @Mappings ({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "version", ignore = true)
  })
  TodoEntity apiToEntity(Todo api);

  List<Todo> entityListToApiList(List<TodoEntity> entity);
  List<TodoEntity> apiListToEntityList(List<Todo> api);

}
