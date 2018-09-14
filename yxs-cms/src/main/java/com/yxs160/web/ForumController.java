package com.yxs160.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 帖子
 */
@Controller
@RequestMapping(value = "/forum")
public class ForumController {

    @GetMapping(value = "/index")
    public String index(){

        return "admin/forum/list";
    }

    @GetMapping(value = "/replyIndex")
    public String replyIndex(){
        return "admin/forum/replys";
    }
}
