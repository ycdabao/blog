package com.imodou.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_article")
public class Article implements java.io.Serializable {

    private Long articleId;
    private String articleTitle;
    private String articleSummary;
    private String articleContent;
    private Long articleViews;
    private Long articleCommentCount;
    private Date articleDate;
    private Long articleLikeCount;
    private Long UserId;
    private String articleCoverPhoto;
}
