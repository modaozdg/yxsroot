package com.yxs.backend.service;

import com.yxs160.model.backend.Article;
import com.yxs160.model.common.Page;
import com.yxs160.model.common.Result;

public interface ArticleService {
    public Result<Article> findListData(Page page);

    public void save(Article article);

    public void edit(Article article);

    public Article getArticleById(Integer id);
}
