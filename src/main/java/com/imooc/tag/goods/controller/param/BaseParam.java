package com.imooc.tag.goods.controller.param;

import lombok.Data;

import java.util.Date;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.controller.param
 * @className: BaseParam
 * @description:
 * @date: 2023/11/21 19:17
 * @version: 1.0
 */
@Data
public class BaseParam {

    private Integer creator;

    private Integer modifier;

    private Date createTime;

    private Date modifyTime;
}
