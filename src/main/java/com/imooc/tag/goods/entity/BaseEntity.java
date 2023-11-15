package com.imooc.tag.goods.entity;

import lombok.Data;

import java.util.Date;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.entity
 * @className: BaseEnttity
 * @description:
 * @date: 2023/11/15 11:14
 * @version: 1.0
 */
@Data
public class BaseEntity {
    private Integer creator;

    private Integer modifier;

    private Date createTime;

    private Date modifyTime;
}
