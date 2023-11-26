基于 SpringBoot + LayUI 开发的 CRUD 的简单管理系统

#### 1、功能点

* 商品管理
* 商品详情
* 标签管理


#### 2、前后端交互接口文档分析

| 模块 | 功能     | 请求地址  | 请求方式 | 请求参数                                                     | 返回值                                                       |
| ---- | -------- | --------- | -------- | :----------------------------------------------------------- | ------------------------------------------------------------ |
| 标签 | 标签列表 | /tag      | GET      | 1、标签id tagId<br />2、标签名称 tagName                     | 1、标签id id<br />2、标签名称 name <br />3、标签样式 style<br />4、标签描述 description<br />5、创建时间 createTime<br />6、编辑时间 modifyTime<br />7、创建人 creator<br />8、编辑人 modifier |
|      | 创建标签 | /tag      | POST     | 1、标签名称 name<br />2、标签样式 style<br />3、标签描述 description<br />4、过期时间 expireTime<br />5、删除是否清除标记 cleanOnDelete<br />6、过期是否清除标记 cleanOnExpire | 1、成功、失败                                                |
|      | 编辑标签 | /tag      | PUT      | 1、标签名称 name<br />2、标签样式 style<br />3、标签描述 description<br />4、过期时间 expireTime<br />5、删除是否清除标记 cleanOnDelete<br />6、过期是否清除标记 cleanOnExpire | 1、成功、失败                                                |
|      | 删除标签 | /tag      | DELETE   | 1、标签id id                                                 | 1、成功、失败                                                |
| 商品 | 商品列表 | /goods    | GET      | 1、商品id goodsId<br />2、商品名称 goodsName                 | 1、商品id id<br />2、商品名称 name<br />3、商品价格 price<br />4、商品图片 img<br />5、商品描述 description<br />6、商品标记 tagList<br />7、创建时间 createTime<br />8、编辑时间 modifyTime<br />9、创建人 creator<br />10、编辑人 modifier |
|      | 创建商品 | /goods    | POST     | 1、商品名称 name<br />2、商品价格 price<br />3、商品描述 description<br />4、商品图片 img | 1、成功、失败                                                |
|      | 编辑商品 | /goods    | PUT      | 1、商品名称 name<br />2、商品价格 price<br />3、商品描述 description<br />4、商品图片 img | 1、成功、失败                                                |
|      | 删除商品 | /goods    | DELETE   | 1、商品id id                                                 | 1、成功、失败                                                |
|      | 商品打标 | /tagGoods | POST     | 1、标签id tagIdList<br />2、商品id goodsId                   | 1、成功、失败                                                |

#### 3、使用ER图设计数据库表与库表生成

##### 商品表

```mysql
CREATE TABLE `goods` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称',
  `price` double NOT NULL COMMENT '商品价格',
  `img` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '商品图片',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `modifier` int NOT NULL DEFAULT '0' COMMENT '最后修改人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `creator` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品表'
```

**标签表**

```mysql

CREATE TABLE `tag` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '标签名称',
  `style` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '标签样式',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '标签描述',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `status` int DEFAULT '0' COMMENT '标签状态，0使用中，1已删除',
  `clean_on_delete` int DEFAULT '0' COMMENT '0标签删除并删除标记，1标签删除但不删除标记',
  `clean_on_expire` int DEFAULT '0' COMMENT '0标签过期并删除标记，1标签过期但不删除标记',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` int NOT NULL DEFAULT '0' COMMENT '最后修改人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `creator` int NOT NULL DEFAULT '0' COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标签表'
```

**标记表**

```mysql
CREATE TABLE `tag_mark` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tag_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '标签id',
  `goods_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '商品id',
  `creator` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` int NOT NULL DEFAULT '0' COMMENT '最后修改人',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品标记表'
```











