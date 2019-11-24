package com.imodou.blog.controller;

import com.imodou.blog.common.constant.Message;
import com.imodou.blog.common.entity.Result;
import com.imodou.blog.pojo.Article;
import com.imodou.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping("addArticle")
    public Result addArticle(@RequestBody Article article, Long[] categoryIds){
        try {
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
}
