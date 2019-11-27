package com.imodou.blog.mapper;

import com.imodou.blog.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author leiwei
 * @since 2019-11-23
 */
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("select ta.* from t_article ta,t_article_category tac where ta.article_id=tac.article_id and tac.category_id=#{categoryId}")
    public Article findByCategoryId(Long categoryId);
}
