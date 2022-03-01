package me.arthur.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.arthur.todo.api.ApiResult;
import me.arthur.todo.api.ApiUtils;
import me.arthur.todo.persistence.ShouldDoEntity;
import me.arthur.todo.persistence.ShouldDoRepository;
import me.arthur.todo.service.ShouldDo;
import me.arthur.todo.service.ShouldDoMapper;

@ResponseBody
@RestController
public class ShouldDoController {
  @Autowired
  ShouldDoRepository shouldDoRepository;

  @Autowired
  ShouldDoMapper mapper;

  @GetMapping(value = "/should-do/{userId}", produces = "application/json")
  ApiResult<List<ShouldDo>> getGivenShouldDoList(@PathVariable String userId) {
    List<ShouldDoEntity> entityList = shouldDoRepository.findAllByToId(userId);
    List<ShouldDo> list = mapper.entityListToApiList(entityList);

    return ApiUtils.success(list);
  }

  @PostMapping(value = "/should-do", consumes = "application/json", produces = "application/json")
  ApiResult<ShouldDo> saveShouldDo(@RequestBody ShouldDo shouldDo) {
    ShouldDoEntity shouldDoEntity = mapper.apiToEntity(shouldDo);
    ShouldDoEntity newEntity = shouldDoRepository.save(shouldDoEntity);

    return ApiUtils.success(mapper.entityToApi(newEntity));
  }
}
