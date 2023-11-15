package com.imooc.tag.goods.controller.vo;

import lombok.Data;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.controller.vo
 * @className: BaseResponse
 * @description:
 * @date: 2023/11/15 13:17
 * @version: 1.0
 */
@Data
public class BaseResponse<T> {
    private Integer code;

    private String message;

    private T data;

    /*返回成功响应**/
    public static <U extends BaseResponse> U getSuccessResult(Class<U> clazz) {
        try {
            U u = clazz.newInstance();
            u.setCode(0);
            u.setMessage("请求成功");
            return u;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }

    };

    /*返回失败响应**/
    public static <U extends BaseResponse> U getFailResult(Class<U> clazz) {
        try {
            U u = clazz.newInstance();
            u.setCode(1);
            u.setMessage("请求失败");
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    };
}
