package com.imooc.tag.goods.entity;

import lombok.Data;



@Data
public class TagEntity extends BaseEntity{
    private Long id;

    private String name;

    private String description;

    private Integer status;

    private String  style;

    private String expireTime;

    private Integer cleanOnDelete;

    private Integer cleanOnExpire;

}
