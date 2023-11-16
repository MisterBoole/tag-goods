package com.imooc.tag.goods.entity;

import lombok.Data;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.entity
 * @className: GoodsEntity
 * @description:
 * @date: 2023/11/15 13:52
 * @version: 1.0
 */

@Data
public class GoodsEntity extends BaseEntity{
    private Long id;

    private String name;

    private Double price;

    private String img;

    private String description;

}
