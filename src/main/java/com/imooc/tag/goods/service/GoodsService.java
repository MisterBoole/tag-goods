package com.imooc.tag.goods.service;

import com.imooc.tag.goods.entity.GoodsEntity;
import com.imooc.tag.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.service
 * @className: GoodsService
 * @description:
 * @date: 2023/11/16 09:09
 * @version: 1.0
 */
@Service
public class GoodsService {
   @Autowired
    private GoodsMapper goodsMapper;

   public List<GoodsEntity> queryGoodsList(Long id, String name) {
       return goodsMapper.queryGoodsList(id, name);
   }

   public Integer inster(GoodsEntity goodsEntity) {
       Integer result = goodsMapper.insert(goodsEntity);
       return result;
   }

   public Integer update(GoodsEntity goodsEntity) {
       Integer result = goodsMapper.update(goodsEntity);
       return result;
   }

   public GoodsEntity queryGoodsById(Long id) {
       return goodsMapper.queryGoodsById(id);
   }

   public Integer delete(Long id) {
       Integer result = goodsMapper.delete(id);
       return result;
   }
}
