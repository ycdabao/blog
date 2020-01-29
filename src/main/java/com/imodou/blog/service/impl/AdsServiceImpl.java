package com.imodou.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.mapper.AdsMapper;
import com.imodou.blog.pojo.Ads;
import com.imodou.blog.pojo.Article;
import com.imodou.blog.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdsServiceImpl implements AdsService {

    @Autowired
    AdsMapper adsMapper;

    @Override
    public PageResult findByCondition(QueryPageBean<Ads> queryPageBean) {
        IPage<Ads> page = new Page<Ads>(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());




        IPage<Ads> mapIPage = adsMapper.selectPage(page, null);

        PageResult result = new PageResult(mapIPage.getTotal(), mapIPage.getRecords());

        return result;
    }


    @Override
    public void addAds(Ads ads) {
        adsMapper.insert(ads);
    }
}
