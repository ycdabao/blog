package com.imodou.blog.service;

import com.imodou.blog.common.entity.CategoryTree;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.pojo.Category;
import com.imodou.blog.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    /**
     * 分页查询分类
     * @param queryPageBean
     * @return
     */
    public PageResult findByCondition(QueryPageBean<User> queryPageBean);

    /**
     * 获取分类树
     * @return
     */
    public List<CategoryTree> getCategoryTree(Long parentId);

    /**
     * 添加新分类
     * @param category
     * @param parentIds
     */
    public void addCategory(@RequestBody Category category, Long[] parentIds);
}
