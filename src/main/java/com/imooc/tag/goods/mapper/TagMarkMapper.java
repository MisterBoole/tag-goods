package com.imooc.tag.goods.mapper;

import com.imooc.tag.goods.entity.TagMarkEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMarkMapper {
    Integer insert (TagMarkEntity tagMarkEntity);

    List<TagMarkEntity> queryTagMarkByGoods(Long goodsId);

    Integer deleteByGoodsId(Long goodsId);

    Integer deleteByTagId(Long tagId);
}
