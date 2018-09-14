package com.yxs160.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理控制
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    /**
     * 首页
     * @return
     */
    @GetMapping(value = "/index")
    public String index(){

        return "admin/index";
    }

    /**
     * 控制台
     * @return
     */
    @GetMapping(value = "/console")
    public String console(){

        return "admin/home/console";
    }
}
