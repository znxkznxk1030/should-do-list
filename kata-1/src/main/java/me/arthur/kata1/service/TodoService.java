package me.arthur.kata1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.arthur.kata1.persistence.TodoEntity;
import me.arthur.kata1.persistence.TodoRepository;

@RestController
public class TodoService {

  @Autowired
  TodoRepository todoRepository;

  @Autowired
  TodoMapper mapper;

  @GetMapping(value = "/todo", produces = "application/json")
  List<Todo> getTodoList() {
    List<TodoEntity> entityList = todoRepository.findAll();
    List<Todo> list = mapper.entityListToApiList(entityList);

    return list;
  }

  @PostMapping(value = "/todo", consumes = "application/json", produces = "application/json")
  Todo saveTodo(@RequestBody Todo todo) {
    TodoEntity todoEntity = mapper.apiToEntity(todo);
    TodoEntity newEntity = todoRepository.save(todoEntity);

    return mapper.entityToApi(newEntity);
  }
}
