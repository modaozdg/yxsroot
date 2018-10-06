package com.yxs.backend.controller;

import com.yxs.backend.service.ArticleService;
import com.yxs160.model.backend.Article;
import com.yxs160.model.common.Page;
import jdk.nashorn.internal.codegen.CompilerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Callable;

/**
 * 文章管理
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;
    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = "/index")
    public String index(){
        return "article/list";
    }

    @PostMapping(value = "/list-data")
    @ResponseBody
    public Callable<Object> listData(Page page){

        return () -> articleService.findListData(page);
    }

    @GetMapping(value = "/to-add")
    public Callable<String> toAdd(){
        return () -> "article/add";
    }

    /**
     * 保存
     * @param article 文章对象
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public Callable<Object> save(Article article){
        return () -> {
            articleService.save(article);
            return null;
        };
    }

    @GetMapping(value = "/to-edit")
    public Callable<ModelAndView> toEdit(Integer id){
        return () -> {
            ModelAndView mv = new ModelAndView();
            mv.addObject("article",articleService.getArticleById(id));
            mv.setViewName("article/edit");
            return mv;
        };
    }

    @PostMapping(value = "/save-edit")
    @ResponseBody
    public Callable<Object> saveEdit(Article article){
        return () -> {
            articleService.edit(article);
            return null;
        };
    }


}
