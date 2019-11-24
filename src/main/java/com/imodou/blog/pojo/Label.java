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
@TableName("t_label")
public class Label extends Model<Label> {

    private static final long serialVersionUID=1L;

    /**
     * 标签ID
     */
    @TableId(value = "label_id", type = IdType.AUTO)
    private Long labelId;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 标签别名
     */
    private String labelAlias;

    /**
     * 标签描述
     */
    private String labelDescription;


    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelAlias() {
        return labelAlias;
    }

    public void setLabelAlias(String labelAlias) {
        this.labelAlias = labelAlias;
    }

    public String getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(String labelDescription) {
        this.labelDescription = labelDescription;
    }

    @Override
    protected Serializable pkVal() {
        return this.labelId;
    }

    @Override
    public String toString() {
        return "Label{" +
        "labelId=" + labelId +
        ", labelName=" + labelName +
        ", labelAlias=" + labelAlias +
        ", labelDescription=" + labelDescription +
        "}";
    }
}
