package com.imodou.blog.controller;

import com.imodou.blog.common.constant.Message;
import com.imodou.blog.common.entity.Result;
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




/*
        @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
        public Map editorMD(HttpServletRequest request, @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) throws IOException {
            HashMap result = new HashMap();

            try {

                //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
                Calendar date = Calendar.getInstance();
                //获得日期路径,MONTH个值的初始值是0，因此我们要用它来表示正确的月份时就需要加1。
                File dateFile = new File(date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+(date.get(Calendar.DATE)));
                //获得文件最初的路径
                String originalFile = file.getOriginalFilename();
                String fileName= UUID.randomUUID().toString()+originalFile.substring(originalFile.lastIndexOf("."));
                //得到完整路径名
                File newFile = new File(uploadPath+File.separator+dateFile+File.separator+fileName);

                */
/*文件不存在就创建*//*

                if(!newFile.getParentFile().exists()){
                    newFile.getParentFile().mkdirs();
                }
                file.transferTo(newFile);
                //System.out.println("/resources/upload/"+dateFile+File.separator+originalFile);
               // System.out.println(dateFile+"/"+file.getOriginalFilename());
                */
/*JSON格式*//*


                result.put("success",1);
                result.put("message",Message.FILE_UPLOAD_SUCCESS);
                result.put("url","/upload/"+date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.DATE)+"/"+fileName);
            } catch (Exception e) {

                result.put("success",0);
                result.put("message",Message.FILE_UPLOAD_FAIL);

            }
            return result;
        }



    @RequestMapping(value = "/uploadCover" ,method = RequestMethod.POST)
    public Result uploadCover(HttpServletRequest request, @RequestParam MultipartFile file) throws IOException {


        try {

            //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
            Calendar date = Calendar.getInstance();
            //获得日期路径,MONTH个值的初始值是0，因此我们要用它来表示正确的月份时就需要加1。
            File dateFile = new File(date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+(date.get(Calendar.DATE)));
            //获得文件最初的路径
            String originalFile = file.getOriginalFilename();
            String fileName= UUID.randomUUID().toString()+originalFile.substring(originalFile.lastIndexOf("."));
            //得到完整路径名
            File newFile = new File(uploadPath+File.separator+dateFile+File.separator+fileName);

            */
/*文件不存在就创建*//*

            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            file.transferTo(newFile);
            //System.out.println("/resources/upload/"+dateFile+File.separator+originalFile);
            // System.out.println(dateFile+"/"+file.getOriginalFilename());
            */
/*JSON格式*//*

          return new Result(true,Message.FILE_UPLOAD_SUCCESS,"/upload/"+date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.DATE)+"/"+fileName);


        } catch (Exception e) {

            return new Result(false,Message.FILE_UPLOAD_FAIL);

        }

    }
*/



}
