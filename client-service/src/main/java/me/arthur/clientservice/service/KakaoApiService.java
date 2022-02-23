package me.arthur.clientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import me.arthur.clientservice.model.KakaoUser;

@Service
public class KakaoApiService {
  private final String KAKAO_HOST = "https://kapi.kakao.com";
  // private final String KAKAO_API_PROFILE = "/v1/api/talk/profile";
  private final String KAKAO_API_ME = "/v2/user/me";
  // private final String KAKAO_API_FRIENDS = "/v1/api/talk/friends";
  
  @Autowired
  private RestTemplate restTemplate;

  public KakaoUser getMyInfo(OAuth2AuthorizedClient authorizedClient) {

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + authorizedClient.getAccessToken().getTokenValue());
    headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
    HttpEntity<String> request = new HttpEntity<>(headers);

    ResponseEntity<KakaoUser> responseEntity = restTemplate.exchange(KAKAO_HOST + KAKAO_API_ME, HttpMethod.GET,
        request, KakaoUser.class);
    
    return responseEntity.getBody();
  }


}
