package com.imooc.tag.goods.common.aspect.annotation;

import java.lang.annotation.*;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.common.aspect.annotation
 * @className: AutoFillDefaultValue
 * @description:
 * @date: 2023/11/15 15:33
 * @version: 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AutoFillDefaultValue {

}
