package com.yxs160.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @GetMapping(value = "/index")
    public String index(){
        return "admin/article/list";
    }

    @GetMapping(value = "/type")
    public String typeIndex(){
        return "admin/article/tags";
    }


    @GetMapping(value = "/reply")
    public String replyIndex(){

        return "admin/article/reply";
    }

}
