package com.imooc.tag.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "xiaoming");
        return "test/test";
    }
}
