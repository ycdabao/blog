package com.imodou.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imodou.blog.common.constant.Message;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.common.entity.Result;
import com.imodou.blog.pojo.Article;
import com.imodou.blog.pojo.User;
import com.imodou.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping("addArticle")
    public Result addArticle(@RequestBody Article article, Long[] categoryIds){
        try {
            article.setArticleDate(new Date());
            articleService.addArticle(article,categoryIds);
            return new Result(true, Message.ARTICLE_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.ARTICLE_ADD_FAIL);
        }
    }


    @GetMapping("findById")
    public Result findById(Long id){
        try {
            Article article = articleService.findById(id);
            return new Result(true,Message.ARTICLE_QUERY_SUCCESS,article);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.ARTICLE_QUERY_FAIL);
        }
    }


    /**
     * 根据分类查询教程
     * @param categoryId
     * @return
     */
    @GetMapping("findByCategoryId")
    public Result findByCategoryId(Long categoryId){
        try {
            Article article = articleService.findByCategoryId(categoryId);
            if(article!=null){
                return new Result(true,Message.ARTICLE_QUERY_SUCCESS,article);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new Result(false,Message.ARTICLE_QUERY_FAIL);
    }

    /**
     * 根据分类分页查询博文
     * @param categoryId
     * @return
     */
    @PostMapping("findArticleByCategoryId")
    public Result findArticleByCategoryId(@RequestBody QueryPageBean<Article> queryPageBean,Long categoryId){
        try {
            PageResult result =  articleService.findArticleByCategoryId(queryPageBean, categoryId);
            return new Result(true, Message.CATEGORY_QUERY_SUCCESS,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.CATEGORY_QUERY_FAIL);
        }

    }

    @PostMapping("pageQuery")
    public Result pageQuery(@RequestBody QueryPageBean<Article> queryPageBean){
        try {
            PageResult result = articleService.findByCondition(queryPageBean);
            return new Result(true, Message.CATEGORY_QUERY_SUCCESS,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.CATEGORY_QUERY_FAIL);
        }
    }


    @GetMapping("delete")
    public Result delete(Long articleId){
        try {
            articleService.delete(articleId);
            return new Result(true,Message.ARTICLE_QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.ARTICLE_QUERY_FAIL);
        }
    }


    @PostMapping("update")
    public Result update(@RequestBody Article article){
        try {
            articleService.update(article);
            return new Result(true,Message.ARTICLE_MODIFY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.ARTICLE_MODIFY_FAIL);
        }
    }
}
