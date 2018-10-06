package com.yxs.backend.mapper;

import com.yxs160.model.backend.Article;
import com.yxs160.model.common.Page;

import java.util.List;

public interface ArticleMapper {
    public List<Article> findListData(Page page);

    public Integer findListDataCount(Page page);

    public void insert(Article article);

    public Article select(Integer id);

    public void update(Article article);
}
