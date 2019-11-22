package com.imodou.blog.controller;

import com.imodou.blog.common.constant.Message;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.common.entity.Result;
import com.imodou.blog.pojo.User;
import com.imodou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/pageQuery")
    public Result pageQuery(@RequestBody QueryPageBean<User> queryPageBean){

        try {
            PageResult result = categoryService.findByCondition(queryPageBean);
            return new Result(true, Message.CATEGORY_QUERY_SUCCESS,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.CATEGORY_QUERY_FAIL);
        }

    }
}
