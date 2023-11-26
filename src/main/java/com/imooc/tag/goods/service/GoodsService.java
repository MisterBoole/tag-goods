package com.imooc.tag.goods.service;

import com.imooc.tag.goods.common.constant.CommonConstant;
import com.imooc.tag.goods.entity.GoodsEntity;
import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.entity.TagMarkEntity;
import com.imooc.tag.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

   @Autowired
   private TagMarkService tagMarkService;

   @Autowired
   private TagService tagService;

   public List<GoodsEntity> queryGoodsList(Long id, String name) {
       List<GoodsEntity> goodsEntities = goodsMapper.queryGoodsList(id, name);
       if(CollectionUtils.isEmpty(goodsEntities)) {
           return new ArrayList<>();
       }

       goodsEntities.forEach(goodsEntity -> {
           List<TagMarkEntity> tagMarkEntities = tagMarkService.queryTagMarkByGoods((goodsEntity.getId()));
           if(!CollectionUtils.isEmpty(tagMarkEntities)) {
               List<Long> tagIdList = tagMarkEntities.stream().map(TagMarkEntity::getTagId).collect(Collectors.toList());
               List<TagEntity> tagEntities = tagService.queryTagByIds(tagIdList);
               goodsEntity.setTagEntityList(tagEntities);
           }
       });

       return goodsEntities;

   }

   private void insertTagMark(GoodsEntity goodsEntity) {
       TagMarkEntity tagMarkEntity = new TagMarkEntity();
       tagMarkEntity.setGoodsId(goodsEntity.getId());
       tagMarkEntity.setTagId(CommonConstant.NEW_SHOP_TAG_ID);
       tagMarkEntity.setCreator(goodsEntity.getCreator());
       tagMarkEntity.setModifier(goodsEntity.getModifier());
       tagMarkEntity.setCreateTime(goodsEntity.getCreateTime());
       tagMarkEntity.setModifyTime(goodsEntity.getModifyTime());
       tagMarkService.insert(tagMarkEntity);
   }

   public Integer inster(GoodsEntity goodsEntity) {
       Integer result = goodsMapper.insert(goodsEntity);
       insertTagMark(goodsEntity);
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
