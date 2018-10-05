package com.yxs.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/home/console")
    public String console(){
        return "home/console";
    }
}
