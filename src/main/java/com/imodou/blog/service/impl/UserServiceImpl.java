package com.imodou.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.mapper.UserMapper;
import com.imodou.blog.pojo.User;
import com.imodou.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }


    @Override
    public User findById(Long id) {
        return userMapper.selectById(id);
    }


    @Override
    public PageResult findByCondition(QueryPageBean<User> queryPageBean) {

        return null;
    }
}


