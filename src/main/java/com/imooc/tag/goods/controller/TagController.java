package com.imooc.tag.goods.controller;

import com.imooc.tag.goods.common.aspect.annotation.AutoFillDefaultValue;
import com.imooc.tag.goods.common.enums.TagStatusEnum;
import com.imooc.tag.goods.controller.vo.BaseResponse;
import com.imooc.tag.goods.controller.vo.TagVO;
import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.service.TagMarkService;
import com.imooc.tag.goods.service.TagService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TagController {
   @Autowired
   private TagService tagService;

   @Autowired
   private TagMarkService tagMarkService;

   @GetMapping("/tag")
    public BaseResponse<List<TagVO>>  queryTagList(Long tagId, String tagName) {
      BaseResponse<List<TagVO>> successResult = BaseResponse.getSuccessResult(BaseResponse.class);
      List<TagEntity> tagEntities = tagService.queryTagList(tagId, tagName);
      List<TagVO> tagVoz = tagEntities.stream().map(TagVO::transferEntityToVO).collect(Collectors.toList());
      successResult.setData(tagVoz);
      return successResult;
   }

   @AutoFillDefaultValue
   @PostMapping("/tag")
   public BaseResponse insert(@RequestBody TagEntity tagEntity) {
       BaseResponse baseResponse = BaseResponse.getSuccessResult(BaseResponse.class);
       tagEntity.setStatus(TagStatusEnum.USE.getCode());
       Integer result = tagService.inster(tagEntity);
       return  baseResponse;
   }

    @PutMapping("/tag")
    public BaseResponse update(@RequestBody TagEntity tagEntity) {
        BaseResponse baseResponse = BaseResponse.getSuccessResult(BaseResponse.class);
        tagEntity.setStatus(TagStatusEnum.USE.getCode());
        Integer result = tagService.update(tagEntity);
        return  baseResponse;
    }

    @DeleteMapping("/tag/{id}")
    public BaseResponse delete(@PathVariable Long id) {
         TagEntity tagEntity = tagService.queryTagById(id);
         if(tagEntity == null) {
             return BaseResponse.getFailResult(BaseResponse.class);
         }
         tagEntity.setStatus(TagStatusEnum.DELETE.getCode());
        Integer result = tagService.update(tagEntity);
        if(tagEntity.getCleanOnDelete() == 0) {
            tagMarkService.deleteByTagId(tagEntity.getId());
        }
        return BaseResponse.getSuccessResult(BaseResponse.class);
    }
}
