package com.imooc.tag.goods.common.aspect.impl;

import com.imooc.tag.goods.controller.param.BaseParam;
import com.imooc.tag.goods.entity.BaseEntity;
import com.imooc.tag.goods.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.common.aspect.impl
 * @className: AutoFillDefaultValueAspect
 * @description:
 * @date: 2023/11/15 15:36
 * @version: 1.0
 */
@Aspect
@Component
public class AutoFillDefaultValueAspect {

    @Pointcut(value = "@annotation(com.imooc.tag.goods.common.aspect.annotation.AutoFillDefaultValue)")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        if("POST".equals(request.getMethod())) {
            if(joinPoint.getArgs().length > 0){
                Object[] args = joinPoint.getArgs();
                for (Object arg : args) {
                    if(arg instanceof BaseEntity ) {
                        BaseEntity baseEntity = (BaseEntity) arg;
                        baseEntity.setCreator(0);
                        baseEntity.setModifier(0);
                        baseEntity.setCreateTime(new Date());
                        baseEntity.setModifyTime(new Date());
                    }

                    if(arg instanceof BaseParam) {
                        BaseParam baseParam = (BaseParam) arg;
                        baseParam.setCreator(0);
                        baseParam.setModifier(0);
                        baseParam.setCreateTime(new Date());
                        baseParam.setModifyTime(new Date());
                    }
                }

            }
        }
    }
}
