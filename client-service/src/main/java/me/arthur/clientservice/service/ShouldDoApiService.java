package me.arthur.clientservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import me.arthur.clientservice.model.ShouldDo;

@Service
public class ShouldDoApiService {

  private final RestTemplate restTemplate;

  @Autowired
  public ShouldDoApiService(
    RestTemplate restTemplate
  ) {
    this.restTemplate = restTemplate;
  }

  public List<ShouldDo> getMyShouldDoList(int userId) {
    List<ShouldDo> ret = new ArrayList<>();
    String url = "http://localhost:8081" + "/should-do/" + userId;

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<?> request = new HttpEntity<>(headers);
    
    // ApiResult<List<ShouldDo>> response = restTemplate.getForObject(todoServiceUrl + "", );
    ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
    ObjectMapper mapper = new ObjectMapper();
    try {
      String json = mapper.writeValueAsString(response.getBody().get("response"));

      System.out.println(json);
      ret = Arrays.asList(mapper.readValue(json, ShouldDo[].class));
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    return ret;
  }

  public ShouldDo createShouldDoList(int userId) {

    return null;
  }

  public ShouldDo updateShouldDo(ShouldDo body) {
    String url = "http://localhost:8081" + "/should-do/";
    restTemplate.getMessageConverters().add(new MappingJackson2CborHttpMessageConverter());

    HttpHeaders headers = new HttpHeaders();

    HttpEntity<ShouldDo> requestEntity = new HttpEntity<ShouldDo>(body, headers);
    HttpEntity<ShouldDo> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, 
        ShouldDo.class);

    return response.getBody();
  }
}
