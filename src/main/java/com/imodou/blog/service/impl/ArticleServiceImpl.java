package com.imodou.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleCategoryMapper articleCategoryMapper;


    @Override
    public PageResult findByCondition(QueryPageBean<Article> queryPageBean) {

        IPage<Article> page = new Page<Article>(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());

        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("article_id", "article_title", "article_summary", "article_views", "article_comment_count", "article_date", "article_like_count", "user_id", "article_cover_photo");
        queryWrapper.orderByDesc("article_date");

        IPage<Article> mapIPage = articleMapper.selectPage(page, queryWrapper);

        PageResult result = new PageResult(mapIPage.getTotal(), mapIPage.getRecords());

        return result;
    }


    @Override
    public void addArticle(Article article, Long[] categoryIds) {
        articleMapper.insert(article);
        Long id = article.getArticleId();

        if (categoryIds != null || categoryIds.length > 0) {
            for (Long categoryId : categoryIds) {
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setArticleId(article.getArticleId());
                articleCategory.setCategoryId(categoryId);
                articleCategoryMapper.insert(articleCategory);
            }
        }
    }


    /**
     * 根据分类分页查询，博文列表
     *
     * @param queryPageBean
     * @return
     */
    public PageResult findArticleByCategoryId(QueryPageBean<Article> queryPageBean, Long categoryId) {
        Page<Article> page = new Page<>(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        List<Article> list = articleMapper.findArticleByCategoryId(page, categoryId);

        PageResult result = new PageResult(page.getTotal(), list);
        return result;

    }


    @Override
    public Article findById(Long id) {
        Article article = articleMapper.selectById(id);

        return article;
    }


    @Override
    public Article findByCategoryId(Long categoryId) {
        return articleMapper.findByCategoryId(categoryId);
    }


    @Override
    public void delete(Long articleId) {
        //删除文章及类别的映射关系
        Map<String, Object> condition = new HashMap<>();
        condition.put("article_id", articleId);
        articleCategoryMapper.deleteByMap(condition);

        //删除文章
        articleMapper.deleteById(articleId);

    }


    @Override
    public void update(Article article) {
        articleMapper.updateById(article);
    }
}
