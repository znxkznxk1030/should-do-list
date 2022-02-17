package me.arthur.kata1.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoService {
  
  @GetMapping(value = "/todo")
  String getTodoList() {
    return "Hello World!";
  }
}
