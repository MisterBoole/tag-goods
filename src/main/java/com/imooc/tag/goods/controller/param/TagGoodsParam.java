package com.imooc.tag.goods.controller.param;

import lombok.Data;

import java.util.List;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.controller.param
 * @className: TagGoodsParam
 * @description:
 * @date: 2023/11/21 19:15
 * @version: 1.0
 */
@Data
public class TagGoodsParam extends BaseParam{
   private Long goodsId;

   private List<Long> tagIdList;
}
