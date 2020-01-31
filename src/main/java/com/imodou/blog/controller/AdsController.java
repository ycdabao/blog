package com.imodou.blog.controller;

import com.imodou.blog.common.constant.Message;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.common.entity.Result;
import com.imodou.blog.pojo.Ads;
import com.imodou.blog.pojo.Article;
import com.imodou.blog.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdsController {

    @Autowired
    private AdsService adsService;

    @RequestMapping("/pageQuery")
    public Result pageQuery(@RequestBody QueryPageBean<Ads> queryPageBean){

        try {
            PageResult result = adsService.findByCondition(queryPageBean);
            return new Result(true, Message.ADS_QUERY_SUCCESS,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.ADS_QUERY_FAIL);
        }

    }


    @RequestMapping("/findByPlace")
    public Result findByPlace(int place){
        try {
            List<Ads> adsList = adsService.findByPlace(place);
            return new Result(true, Message.ADS_QUERY_SUCCESS,adsList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.ADS_QUERY_FAIL);
        }
    }


    @PostMapping("addAds")
    public Result addAds(@RequestBody Ads ads){
        try {
            ads.setCreatetime(new Date());
            ads.setPlace(1);
            ads.setStatus(1);

            adsService.addAds(ads);
            return new Result(true, Message.ARTICLE_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,Message.ARTICLE_ADD_FAIL);
        }
    }

}
