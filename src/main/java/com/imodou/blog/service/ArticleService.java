package com.imodou.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.pojo.Article;

import java.util.List;

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


    /**
     * 根据分类查询,查询教程
     * @param categoryId
     * @return
     */
    public Article findByCategoryId(Long categoryId);


    /**
     * 根据分类分页查询，博文列表
     * @param queryPageBean
     * @return
     */
    public PageResult findArticleByCategoryId(QueryPageBean<Article> queryPageBean, Long categoryId);


    /**
     * 根据id删除
     * @param articleId
     */
    public void delete(Long articleId);


    /*

     */
    public void update(Article article);
}
