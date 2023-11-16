package com.hdd.winterSolsticeBlog.wrapper;

import java.util.List;

/**
 * Data Transfer Object数据传输对象与Entity实体类相互转换
 *
 * @param <DTO>
 * @param <Entity>
 */
public interface BaseDTOEntityWrapper<DTO, Entity> {

    DTO toDTOFromEntity(Entity entity);

    Entity toEntityFromDTO(DTO dto);

    List<DTO> toDTOListFromEntity(List<Entity> entities);

    List<Entity> toEntityListFromDTO(List<DTO> dtos);
}
