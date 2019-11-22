package com.imodou.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("t_category")
public class Category implements java.io.Serializable{

    //@TableField("category_id")
    private Long categoryId;
    //@TableField("category_name")
    private String categoryName;
   // @TableField("category_alias")
    private String categoryAlias;
   // @TableField("category_description")
    private String categoryDescription;
   // @TableField("parent_category_id")
    private Long parentCategoryId;
   // @TableField("category_sort")
    private Integer categorySort;

    @TableField(exist = false)
    private List<Category> child;
}
