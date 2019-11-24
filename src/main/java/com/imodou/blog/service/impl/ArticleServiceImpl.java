package com.imodou.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.mapper.ArticleCategoryMapper;
import com.imodou.blog.mapper.ArticleMapper;
import com.imodou.blog.pojo.Article;
import com.imodou.blog.pojo.ArticleCategory;
import com.imodou.blog.pojo.Category;
import com.imodou.blog.pojo.User;
import com.imodou.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleCategoryMapper articleCategoryMapper;


    @Override
    public PageResult findByCondition(QueryPageBean<Article> queryPageBean) {

        IPage<Article> page=  new Page<Article>(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());

        IPage<Article> mapIPage = articleMapper.selectPage(page, null);

        PageResult result = new PageResult(mapIPage.getTotal(),mapIPage.getRecords());

        return result;
    }



    @Override
    public void addArticle(Article article, Long[] categoryIds) {
            articleMapper.insert(article);
            Long id = article.getArticleId();

            if(categoryIds!=null||categoryIds.length>0){
                for (Long categoryId : categoryIds) {
                    ArticleCategory articleCategory=new ArticleCategory();
                    articleCategory.setArticleId(article.getArticleId());
                    articleCategory.setCategoryId(categoryId);
                    articleCategoryMapper.insert(articleCategory);
                }
            }
    }

    @Override
    public Article findById(Long id) {
        Article article = articleMapper.selectById(id);

        return article;
    }
}
