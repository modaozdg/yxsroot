package com.yxs.backend.service.impl;

import com.yxs.backend.mapper.ArticleMapper;
import com.yxs.backend.service.ArticleService;
import com.yxs160.model.backend.Article;
import com.yxs160.model.common.Page;
import com.yxs160.model.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    private ArticleMapper articleMapper;
    @Autowired
    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public Result<Article> findListData(Page page) {
        Result<Article> result = new Result<>();
        result.setData(articleMapper.findListData(page));
        result.setCount(articleMapper.findListDataCount(page));
        return result;
    }

    @Override
    public void save(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public void edit(Article article) {
        articleMapper.update(article);
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.select(id);
    }
}
