package com.imooc.tag.goods.mapper;

import com.imooc.tag.goods.entity.TagEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.mapper
 * @className: TagMapper
 * @description:
 * @date: 2023/11/15 10:44
 * @version: 1.0
 */

@Mapper
public interface TagMapper {
  List<TagEntity> queryTagList(@Param("id") Long id, @Param("name") String name);

  TagEntity queryTagById(@Param("id") Long id);

  Integer insert(TagEntity tagEntity);

  Integer update(TagEntity tagEntity);

  List<TagEntity> queryTagByIds(@Param("ids") List<Long> ids);
}
