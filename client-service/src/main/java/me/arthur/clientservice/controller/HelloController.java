package me.arthur.clientservice.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {

  Logger log = LoggerFactory.getLogger(HelloController.class);

  @GetMapping(value = "/hello")
  public List<String> hello(@RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient) {
    log.debug(authorizedClient.getAccessToken().getTokenValue());
    return Arrays.asList("안녕하세요", "Hello");
  }

}
