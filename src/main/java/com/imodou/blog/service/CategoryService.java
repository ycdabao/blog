package com.imodou.blog.service;

import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.pojo.User;

public interface CategoryService {

    public PageResult findByCondition(QueryPageBean<User> queryPageBean);
}
