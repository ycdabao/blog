package com.imodou.blog.controller;

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


    @GetMapping("findByCategoryId")
    public Result findByCategoryId(Long categoryId){
        try {
            Article article = articleService.findByCategoryId(categoryId);
            return new Result(true,Message.ARTICLE_QUERY_SUCCESS,article);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.ARTICLE_QUERY_FAIL);
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
}
