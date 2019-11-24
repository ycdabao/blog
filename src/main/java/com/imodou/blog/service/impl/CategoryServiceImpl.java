package com.imodou.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imodou.blog.common.entity.CategoryTree;
import com.imodou.blog.common.entity.PageResult;
import com.imodou.blog.common.entity.QueryPageBean;
import com.imodou.blog.mapper.CategoryMapper;
import com.imodou.blog.pojo.Category;
import com.imodou.blog.pojo.User;
import com.imodou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageResult findByCondition(QueryPageBean<User> queryPageBean) {

        IPage<Category> page=  new Page<Category>(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());

        IPage<Category> mapIPage = categoryMapper.selectPage(page, null);

        PageResult result = new PageResult(mapIPage.getTotal(),mapIPage.getRecords());

        return result;
    }


    @Override
    public List<CategoryTree> getCategoryTree() {

        List<Category> categories = categoryMapper.selectList(null);

        return buildTree(categories,null);
    }


    private List<CategoryTree> buildTree(List<Category> categories,Long parentId){
        List<CategoryTree> tree= new ArrayList<>();
        for (Category category : categories) {
                if(category.getParentCategoryId()==parentId) {
                    CategoryTree t = new CategoryTree();
                    t.setLabel(category.getCategoryName());
                    t.setValue(category.getCategoryId());
                    List<CategoryTree> chidren = buildTree(categories, t.getValue());
                    t.setChildren(chidren);
                    tree.add(t);
                }
        }

        return tree;
    }

    @Override
    public void addCategory(Category category, Long[] parentIds) {
        //如果前台未传父ID，则将该分类设置为一级分类
        if(parentIds==null||parentIds.length==0){
            category.setParentCategoryId(null);
        }else{
            //如果前台传过来父ID，则设置数组中的最后一个为父ID
            Long parentId= parentIds[parentIds.length-1];
            category.setParentCategoryId(parentId);
        }
        categoryMapper.insert(category);
    }
}
