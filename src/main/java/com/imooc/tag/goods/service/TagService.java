package com.imooc.tag.goods.service;

import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
  @Autowired
  private TagMapper tagMapper;

  public List<TagEntity> queryTagList(Long id, String name) {
      return tagMapper.queryTagList(id, name);
  }

  public Integer inster(TagEntity tagEntity) {
      Integer result = tagMapper.insert(tagEntity);
      return result;
  }
}
