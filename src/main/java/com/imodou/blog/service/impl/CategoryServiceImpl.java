package com.imodou.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.mapper.CategoryMapper;
import com.imodou.blog.pojo.Category;
import com.imodou.blog.pojo.User;
import com.imodou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageResult findByCondition(QueryPageBean<User> queryPageBean) {

        IPage<Category> page=  new Page<Category>(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());

        IPage<Category> mapIPage = categoryMapper.selectPage(page, null);

        PageResult result = new PageResult(mapIPage.getTotal(),mapIPage.getRecords());

        return result;
    }
}
