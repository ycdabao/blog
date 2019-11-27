package com.imodou.blog.service;

import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.pojo.Article;

public interface ArticleService {

    /**
     * 发布内容，并添加对应分类信息
     * @param article
     * @param categoryIds
     */
    public void  addArticle(Article article,Long[] categoryIds);

    /**
     * 根据ID获取内容
     * @param id
     * @return
     */
    public Article findById(Long id);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    public PageResult findByCondition(QueryPageBean<Article> queryPageBean);


    public Article findByCategoryId(Long categoryId);
}
