package me.arthur.clientservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import me.arthur.clientservice.model.ShouldDo;

@Service
public class ShouldDoApiService {

  private final RestTemplate restTemplate;
  private final String todoServiceUrl;

  @Autowired
  public ShouldDoApiService(
    RestTemplate restTemplate,
    @Value("${app.todo-service.host") String todoServiceHost,
    @Value("${app.todo-service.port") String todoServicePort
  ) {
    this.restTemplate = restTemplate;
    this.todoServiceUrl = "http://" + todoServiceHost + ":" + todoServicePort;
  }

  public List<ShouldDo> getMyShouldDoList(int userId) {

    
    return null;
  }
}
