package com.imodou.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.pojo.User;

public interface UserService {

    public void add(User user);

    public User findById(Long id);

    public PageResult findByCondition(QueryPageBean<User> queryPageBean);

}
