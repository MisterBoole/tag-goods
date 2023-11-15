package com.imooc.tag.goods.entity;

import lombok.Data;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.entity
 * @className: TagMarkEntity
 * @description:
 * @date: 2023/11/15 13:52
 * @version: 1.0
 */
@Data
public class TagMarkEntity extends BaseEntity{
    private Long id;

    private String tagId;

    private String goodsId;

}
