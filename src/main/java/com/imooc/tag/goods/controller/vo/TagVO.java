package com.imooc.tag.goods.controller.vo;

import com.imooc.tag.goods.entity.TagEntity;
import lombok.Data;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.controller.vo
 * @className: TagVo
 * @description:
 * @date: 2023/11/15 13:30
 * @version: 1.0
 */
@Data
public class TagVO extends BaseVO{
    private Long id;

    private String name;

    private String description;

    private Integer status;

    private String  style;

    private String expireTime;

    public static TagVO transferEntityToVO(TagEntity tagEntity) {
        TagVO tagVO = new TagVO();
        tagVO.setId(tagEntity.getId());
        tagVO.setName(tagEntity.getName());
        tagVO.setStyle(tagEntity.getStyle());
        tagVO.setDescription(tagEntity.getDescription());
        tagVO.setCreater(tagEntity.getCreater());
        tagVO.setModifier(tagEntity.getModifier());
        tagVO.setCreateTime(tagEntity.getCreateTime());
        tagVO.setModifyTime(tagEntity.getModifyTime());
        return tagVO;
    }
}
