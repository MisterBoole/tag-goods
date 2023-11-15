package com.imooc.tag.goods.controller;

import com.imooc.tag.goods.controller.vo.BaseResponse;
import com.imooc.tag.goods.controller.vo.TagVO;
import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TagController {
   @Autowired
   private TagService tagService;

   @GetMapping("/tag")
    public BaseResponse<List<TagVO>>  queryTagList(Long tagId, String tagName) {
      BaseResponse<List<TagVO>> successResult = BaseResponse.getSuccessResult(BaseResponse.class);
      List<TagEntity> tagEntities = tagService.queryTagList(tagId, tagName);
      List<TagVO> tagVoz = tagEntities.stream().map(TagVO::transferEntityToVO).collect(Collectors.toList());
      successResult.setData(tagVoz);
      return successResult;
   }
}
