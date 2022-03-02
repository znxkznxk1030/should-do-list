package me.arthur.clientservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.arthur.clientservice.api.ApiResult;
import me.arthur.clientservice.api.ApiUtils;
import me.arthur.clientservice.model.KakaoUser;
import me.arthur.clientservice.model.ShouldDo;
import me.arthur.clientservice.service.KakaoApiService;
import me.arthur.clientservice.service.ShouldDoApiService;

@RestController
@RequestMapping("/api/v1")
public class ShouldDoController {
  Logger log = LoggerFactory.getLogger(ShouldDoController.class);

  @Autowired
  KakaoApiService kakaoApiService;

  @Autowired
  ShouldDoApiService souldDoApiService;

  @GetMapping(value= "/should-do", produces = "application/json")
  public ApiResult<List<ShouldDo>> getShouldDoList(
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient) {

      KakaoUser me = kakaoApiService.getMyInfo(authorizedClient);
      Integer userId = me.getId().intValue();
      List<ShouldDo> list = souldDoApiService.getShouldDoList(userId);
    return ApiUtils.success(list);
  }

  @GetMapping(value = "/should-do/given", produces = "application/json")
  public ApiResult<List<ShouldDo>> getGivenShouldDoList(
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient) {

    KakaoUser me = kakaoApiService.getMyInfo(authorizedClient);
    Integer userId = me.getId().intValue();
    List<ShouldDo> list = souldDoApiService.getGivenShouldDoList(userId);
    return ApiUtils.success(list);
  }

  @PutMapping(value = "/should-do", produces = "application/json", consumes = "application/json")
  public ApiResult<?> updateShouldDo(
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient, 
      @RequestBody ShouldDo shouldDo) {

    KakaoUser me = kakaoApiService.getMyInfo(authorizedClient);
    System.out.println(Long.toString(me.getId()));
    System.out.println(shouldDo.getToId());
    if (!Long.toString(me.getId()).equals(shouldDo.getToId())) {
      return ApiUtils.error("userId not matched", HttpStatus.BAD_REQUEST);
    }
    ShouldDo _shouldDo = souldDoApiService.updateShouldDo(shouldDo);
    return ApiUtils.success(_shouldDo);
  }

  @PostMapping(value = "/should-do", produces = "application/json", consumes = "application/json")
  public ApiResult<?> createShouldDo(
      @RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient,
      @RequestBody ShouldDo shouldDo) {

    KakaoUser user = kakaoApiService.getMyInfo(authorizedClient);
    shouldDo.setFromId(String.valueOf(user.getId()));
    System.out.println(shouldDo.toString());
    log.info("====== createShouldDo ======");
    log.info(shouldDo.toString());
    ShouldDo _shouldDo = souldDoApiService.createShouldDo(shouldDo);
    return ApiUtils.success(_shouldDo);
  }
}
