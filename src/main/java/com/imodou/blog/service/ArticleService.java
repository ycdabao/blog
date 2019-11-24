package com.imodou.blog.service;

import com.imodou.blog.pojo.Article;

public interface ArticleService {

    public void  addArticle(Article article,Long[] categoryIds);

    public Article findById(Long id);
}
