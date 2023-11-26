package com.imooc.tag.goods.service;

import com.imooc.tag.goods.entity.TagMarkEntity;
import com.imooc.tag.goods.mapper.TagMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.service
 * @className: TagMarkService
 * @description:
 * @date: 2023/11/21 18:56
 * @version: 1.0
 */
@Service
public class TagMarkService {
    @Autowired
   private TagMarkMapper tagMarkMapper;

   public Integer insert(TagMarkEntity tagMarkEntity) {
       return tagMarkMapper.insert(tagMarkEntity);
   }

   public List<TagMarkEntity> queryTagMarkByGoods(Long goodsId) {
       return tagMarkMapper.queryTagMarkByGoods(goodsId);
   }

   public Integer deleteByGoodsId(Long goodsId) {
       return tagMarkMapper.deleteByGoodsId(goodsId);
   }

    public Integer deleteByTagId(Long tagId) {
        return tagMarkMapper.deleteByTagId(tagId);
    }
}
