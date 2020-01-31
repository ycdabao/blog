package com.imodou.blog.service;

import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.common.entity.Result;
import com.imodou.blog.pojo.Ads;
import com.imodou.blog.pojo.Article;

import java.util.List;

public interface AdsService {

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    public PageResult findByCondition(QueryPageBean<Ads> queryPageBean);


    public void addAds(Ads ads);

    public List<Ads> findByPlace(int place);

}
