package me.arthur.todo.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import me.arthur.todo.persistence.ShouldDoEntity;

@Mapper(componentModel = "spring")
public interface ShouldDoMapper {

  ShouldDo entityToApi(ShouldDoEntity entity);

  // Java 8 and later
  @Mappings ({
    // @Mapping(target = "id", ignore = true),
    @Mapping(target = "version", ignore = true)
  })
  ShouldDoEntity apiToEntity(ShouldDo api);

  List<ShouldDo> entityListToApiList(List<ShouldDoEntity> entity);
  List<ShouldDoEntity> apiListToEntityList(List<ShouldDo> api);

}
