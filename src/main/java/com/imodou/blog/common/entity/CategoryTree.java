package com.imodou.blog.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.imodou.blog.pojo.Category;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)     //忽略空
public class CategoryTree {
    private Long value;
    private String label;

    private List<CategoryTree> children;
}
