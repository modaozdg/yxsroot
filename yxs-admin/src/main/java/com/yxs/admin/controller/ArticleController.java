package com.yxs.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章管理
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @GetMapping(value = "/index")
    public String index(){
        return "article/list";
    }
}
