package me.arthur.clientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.arthur.clientservice.model.ShouldDo;
import me.arthur.clientservice.service.KakaoApiService;
import me.arthur.clientservice.service.ShouldDoApiService;

@RestController
@RequestMapping("/api/v1/should-do")
public class ShouldDoController {
  @Autowired
  KakaoApiService kakaoApiService;

  @Autowired
  ShouldDoApiService souldDoApiService;

  @GetMapping(value="/mine")
  public List<ShouldDo> getMyShouldDoList(
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient) {

    return null;
  }
}
