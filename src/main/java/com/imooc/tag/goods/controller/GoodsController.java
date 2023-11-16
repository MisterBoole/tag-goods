package com.imooc.tag.goods.controller;

import com.imooc.tag.goods.controller.vo.BaseResponse;
import com.imooc.tag.goods.controller.vo.GoodsVO;
import com.imooc.tag.goods.entity.GoodsEntity;
import com.imooc.tag.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

   @GetMapping("/goods")
    public BaseResponse<List<GoodsVO>> queryGoodsList(Long goodsId, String goodsName) {
       BaseResponse successResult = BaseResponse.getSuccessResult(BaseResponse.class);
       List<GoodsEntity> goodsEntitys = goodsService.queryGoodsList(goodsId, goodsName);
       List<GoodsVO> goodsVOS = goodsEntitys.stream().map(GoodsVO::transferEntityToVO).collect(Collectors.toList());
       successResult.setData(goodsVOS);
       return successResult;
   }


}