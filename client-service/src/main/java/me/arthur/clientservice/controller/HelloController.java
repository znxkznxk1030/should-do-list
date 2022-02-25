package me.arthur.clientservice.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vdurmont.emoji.EmojiParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// import me.arthur.clientservice.model.KakaoUser;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {

  Logger log = LoggerFactory.getLogger(HelloController.class);

  String KAKAO_HOST = "https://kapi.kakao.com";
  String KAKAO_API_PROFILE = "/v1/api/talk/profile";
  String KAKAO_API_ME = "/v2/user/me";
  String KAKAO_API_FRIENDS = "/v1/api/talk/friends";

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping(value = "/hello")
  public List<String> hello(Principal principal,
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient) {
    return Arrays.asList("안녕하세요", "Hello");
  }

  @GetMapping(value = "/user/profile", produces = "application/json")
  public String Profile(Principal principal,
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient) {

    HttpHeaders headers = new HttpHeaders(); 
    headers.set("Authorization", "Bearer " + authorizedClient.getAccessToken().getTokenValue()); 
    HttpEntity<String> request = new HttpEntity<>(headers);
    
   ResponseEntity<String> responseEntity = restTemplate.exchange(KAKAO_HOST + KAKAO_API_PROFILE, HttpMethod.GET, 
       request, String.class);
    

    return responseEntity.getBody();
  }

  @GetMapping(value = "/user/me", produces = "application/json")
  public String Me(Principal principal,
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient) {
    String nickname = "";

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + authorizedClient.getAccessToken().getTokenValue());
    headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
    // HttpEntity<String> request = new HttpEntity<>(headers);

    // ResponseEntity<KakaoUser> responseEntity = restTemplate.exchange(KAKAO_HOST + KAKAO_API_ME, HttpMethod.GET,
        // request, KakaoUser.class);
    

    return nickname;
  }

  @GetMapping(value = "/user/friends", produces = "application/json")
  public String Friends(Principal principal,
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient) {
    String nickname = "";

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + authorizedClient.getAccessToken().getTokenValue());
    headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
    HttpEntity<String> request = new HttpEntity<>(headers);

    ResponseEntity<String> responseEntity = restTemplate.exchange(KAKAO_HOST + KAKAO_API_FRIENDS, HttpMethod.GET,
        request, String.class);
    
    System.out.println(responseEntity.getBody());

    String response = EmojiParser.removeAllEmojis(responseEntity.getBody());

    System.out.println(response);
    return responseEntity.getBody();
  }

  
}
