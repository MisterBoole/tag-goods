package com.imooc.tag.goods.controller.vo;

import com.imooc.tag.goods.entity.GoodsEntity;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.controller.vo
 * @className: GoodsVO
 * @description:
 * @date: 2023/11/16 09:35
 * @version: 1.0
 */
@Data
public class GoodsVO extends BaseVO{
    private Long id;

    private String name;

    private Double price;

    private String img;

    private String description;

    private List<TagVO> tagList;

    public static GoodsVO transferEntityToVO(GoodsEntity goodsEntity) {
        GoodsVO goodsVO = new GoodsVO();
        goodsVO.setId(goodsEntity.getId());
        goodsVO.setName(goodsEntity.getName());
        goodsVO.setPrice(goodsEntity.getPrice());
        goodsVO.setDescription(goodsEntity.getDescription());
        goodsVO.setImg(goodsEntity.getImg());
        goodsVO.setCreator(goodsEntity.getCreator());
        goodsVO.setModifier(goodsEntity.getModifier());
        goodsVO.setCreateTime(goodsEntity.getCreateTime());
        goodsVO.setModifyTime(goodsEntity.getModifyTime());
        if(!CollectionUtils.isEmpty(goodsEntity.getTagEntityList())) {
           goodsVO.setTagList(goodsEntity.getTagEntityList().stream().map(TagVO::transferEntityToVO).collect(Collectors.toList()));
        }
        return goodsVO;
    }

}
