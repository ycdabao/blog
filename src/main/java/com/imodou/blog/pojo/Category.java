package com.imodou.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author leiwei
 * @since 2019-11-23
 */
@TableName("t_category")
public class Category extends Model<Category> {

    private static final long serialVersionUID=1L;

    /**
     * 分类ID
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类别名
     */
    private String categoryAlias;

    /**
     * 分类描述
     */
    private String categoryDescription;

    /**
     * 父分类ID
     */
    private Long parentCategoryId;

    /**
     * 排序
     */
    private Integer categorySort;

    private String categoryLinkurl;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Integer getCategorySort() {
        return categorySort;
    }

    public void setCategorySort(Integer categorySort) {
        this.categorySort = categorySort;
    }

    public String getCategoryLinkurl() {
        return categoryLinkurl;
    }

    public void setCategoryLinkurl(String categoryLinkurl) {
        this.categoryLinkurl = categoryLinkurl;
    }

    @Override
    protected Serializable pkVal() {
        return this.categoryId;
    }

    @Override
    public String toString() {
        return "Category{" +
        "categoryId=" + categoryId +
        ", categoryName=" + categoryName +
        ", categoryAlias=" + categoryAlias +
        ", categoryDescription=" + categoryDescription +
        ", parentCategoryId=" + parentCategoryId +
        ", categorySort=" + categorySort +
        ", categoryLinkurl=" + categoryLinkurl +
        "}";
    }
}
