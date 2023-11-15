package com.imooc.tag.goods.controller.vo;

import lombok.Data;

import java.util.Date;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.controller.vo
 * @className: BaseVO
 * @description:
 * @date: 2023/11/15 13:31
 * @version: 1.0
 */
@Data
public class BaseVO {
    private Integer creator;

    private Integer modifier;

    private Date createTime;

    private Date modifyTime;
}
