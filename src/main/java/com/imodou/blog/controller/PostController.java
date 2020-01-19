package com.imodou.blog.controller;

import com.imodou.blog.common.constant.Message;
import com.imodou.blog.common.entity.Result;
import com.imodou.blog.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/post")
@PropertySource("classpath:application.yml")
public class PostController {




        @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
        public Map editorMD(HttpServletRequest request, @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) throws IOException {
            HashMap result = new HashMap();

            try {
                String originalFile = file.getOriginalFilename();
                String fileName= UUID.randomUUID().toString()+originalFile.substring(originalFile.lastIndexOf("."));

                QiniuUtil.upload(file.getInputStream(),fileName);


                result.put("success",1);
                result.put("message",Message.FILE_UPLOAD_SUCCESS);
                result.put("url","http://cdn.imodou.com.cn/"+fileName);
            } catch (Exception e) {

                result.put("success",0);
                result.put("message",Message.FILE_UPLOAD_FAIL);

            }
            return result;
        }



    @RequestMapping(value = "/uploadCover" ,method = RequestMethod.POST)
    public Result uploadCover(HttpServletRequest request, @RequestParam MultipartFile file) throws IOException {


        try {

            String originalFile = file.getOriginalFilename();
            String fileName= UUID.randomUUID().toString()+originalFile.substring(originalFile.lastIndexOf("."));

            QiniuUtil.upload(file.getInputStream(),fileName);

          return new Result(true,Message.FILE_UPLOAD_SUCCESS,"http://cdn.imodou.com.cn/"+fileName);


        } catch (Exception e) {

            return new Result(false,Message.FILE_UPLOAD_FAIL);

        }

    }



}
