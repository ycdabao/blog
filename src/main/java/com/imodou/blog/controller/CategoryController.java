package com.imodou.blog.controller;

import com.imodou.blog.common.constant.Message;
import com.imodou.blog.common.entity.CategoryTree;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.common.entity.Result;
import com.imodou.blog.pojo.Category;
import com.imodou.blog.pojo.User;
import com.imodou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 获取分类
     * @return
     */
    @RequestMapping("/getCategoryTree")
    public Result getCategoryTree(Long parentId){
        try {
            List<CategoryTree> categoryTree = categoryService.getCategoryTree(null);
            return new Result(true, Message.CATEGORY_QUERY_SUCCESS,categoryTree);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.CATEGORY_QUERY_FAIL);
        }
    }


    @RequestMapping("/addCategory")
    public Result addCategory(@RequestBody Category category,Long[] parentIds){
        try {
            categoryService.addCategory(category,parentIds);
            return new Result(true,Message.CATEGORY_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.CATEGORY_ADD_FAIL);
        }
    }
}
