package com.yxs160.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /**
     * 错误页面
     * @return
     */
    @RequestMapping(value = "/error")
    public Object error(){

        return "error";
    }

    /**
     * 根路径
     * @return
     */
    @RequestMapping(value = "/")
    public String index(){

        return "index";
    }
    /**
     * 404访问
     */
    @RequestMapping(value = "/404")
    public String page404(){

        return "404";
    }
}
