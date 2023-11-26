package com.imooc.tag.goods.common.schedule;

import com.imooc.tag.goods.common.enums.TagStatusEnum;
import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.service.TagMarkService;
import com.imooc.tag.goods.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @projectName: tag-goods
 * @package: com.imooc.tag.goods.common.schedule
 * @className: TagExpireSchedule
 * @description:
 * @date: 2023/11/26 17:45
 * @version: 1.0
 */
@Configuration
@EnableScheduling
@Slf4j
public class TagExpireSchedule {

    @Autowired
    private TagService tagService;

    private TagMarkService tagMarkService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void schedule() {
       log.info("TagExpireSchedule|schedule start");
       // 1、获取过期的时间
        List<TagEntity> tagEntities = tagService.queryExpiredTag(new Date());
        // 2、判断非空时候
        if(!CollectionUtils.isEmpty(tagEntities)) {
            tagEntities.forEach(tagEntitie -> {
                // 3、置成过期
                tagEntitie.setStatus(TagStatusEnum.EXPIRE.getCode());
                tagService.update(tagEntitie);
                if(tagEntitie.getCleanOnExpire() == 0) {
                    // 3、如果 == 0, 就根据标签删除商品上的标签标记
                    tagMarkService.deleteByTagId(tagEntitie.getId());
                }
            });
        }


    }
}
