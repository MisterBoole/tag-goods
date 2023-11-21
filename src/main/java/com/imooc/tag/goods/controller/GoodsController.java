package com.imooc.tag.goods.controller;

import com.imooc.tag.goods.common.aspect.annotation.AutoFillDefaultValue;
import com.imooc.tag.goods.controller.param.TagGoodsParam;
import com.imooc.tag.goods.controller.vo.BaseResponse;
import com.imooc.tag.goods.controller.vo.GoodsVO;
import com.imooc.tag.goods.entity.BaseEntity;
import com.imooc.tag.goods.entity.GoodsEntity;
import com.imooc.tag.goods.entity.TagMarkEntity;
import com.imooc.tag.goods.service.GoodsService;
import com.imooc.tag.goods.service.TagMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.controller
 * @className: GoodsController
 * @description:
 * @date: 2023/11/16 09:17
 * @version: 1.0
 */
@RestController
public class GoodsController {
   @Autowired
    private GoodsService goodsService;

   @Autowired
   private TagMarkService tagMarkService;

   @GetMapping("/goods")
    public BaseResponse<List<GoodsVO>> queryGoodsList(Long goodsId, String goodsName) {
       BaseResponse successResult = BaseResponse.getSuccessResult(BaseResponse.class);
       List<GoodsEntity> goodsEntitys = goodsService.queryGoodsList(goodsId, goodsName);
       List<GoodsVO> goodsVOS = goodsEntitys.stream().map(GoodsVO::transferEntityToVO).collect(Collectors.toList());
       successResult.setData(goodsVOS);
       return successResult;
   }

   @AutoFillDefaultValue
   @PostMapping("/goods")
   public BaseResponse insert(@RequestBody GoodsEntity goodsEntity) {
       BaseResponse baseResponse = BaseResponse.getSuccessResult(BaseResponse.class);
       Integer result = goodsService.inster(goodsEntity);
       return baseResponse;
   }

   @DeleteMapping("/goods/{id}")
   public BaseResponse delete(@PathVariable Long id) {
       Integer result = goodsService.delete(id);
       if(result > 0) {
           return BaseResponse.getSuccessResult(BaseResponse.class);
       }
       return BaseResponse.getFailResult(BaseResponse.class);
   }

   @PutMapping("/goods")
   public BaseResponse update(@RequestBody GoodsEntity goodsEntity) {
       BaseResponse successResult = BaseResponse.getSuccessResult(BaseResponse.class);
       Integer update = goodsService.update(goodsEntity);
       return successResult;
   }

   @AutoFillDefaultValue
   @PostMapping("/tagGoods")
   public BaseResponse tagGoods(@RequestBody TagGoodsParam tagGoodsParam) {
       tagMarkService.deleteByGoodsId(tagGoodsParam.getGoodsId());
       tagGoodsParam.getTagIdList().forEach(tagId -> {
           TagMarkEntity tagMarkEntity = new TagMarkEntity();
           tagMarkEntity.setGoodsId(tagGoodsParam.getGoodsId());
           tagMarkEntity.setTagId(tagId);
           tagMarkEntity.setCreator(tagGoodsParam.getCreator());
           tagMarkEntity.setModifier(tagGoodsParam.getModifier());
           tagMarkEntity.setCreateTime(tagGoodsParam.getCreateTime());
           tagMarkEntity.setModifyTime(tagGoodsParam.getModifyTime());
           tagMarkService.insert(tagMarkEntity);
       });

       return BaseResponse.getSuccessResult(BaseResponse.class);
   }



}
