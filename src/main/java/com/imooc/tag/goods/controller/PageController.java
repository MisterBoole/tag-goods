package com.imooc.tag.goods.controller;

import com.imooc.tag.goods.common.aspect.annotation.AutoFillDefaultValue;
import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "xiaoming");
        return "test/test";
    }

    @RequestMapping("/")
    public String main() {
        return "main/main";
    }

    // 标签相关
    @RequestMapping("/tag/tagList")
    public String tagList() {
        return "tag/tagList";
    }

    @RequestMapping("/tag/tagAdd")
    public String tagAdd() {
        return "tag/tagAdd";
    }

    @RequestMapping("/tag/tagUpdate/{id}")
    public String tagUpdate(@PathVariable long id, Model model) {
        TagEntity tagEntity = tagService.queryTagById(id);
        model.addAttribute("tag", tagEntity);
        return "tag/tagUpdate";
    }

    // 商品相关
    @RequestMapping("/goods/goodsList")
    public String goodsList() {
        return "goods/goodsList";
    }

    @RequestMapping("/goods/goodsAdd")
    public String goodsAdd() {
        return "goods/goodsAdd";
    }
}
