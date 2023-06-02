package com.ruoyi.chat.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模型对象 chat_model
 * 
 * @author wangxi
 * @date 2023-05-10
 */
public class ChatModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    /** 描述 */
    @Excel(name = "描述")
    private String describ;

    /** 模型内容 */
    @Excel(name = "模型内容")
    private String content;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setDescrib(String describ)
    {
        this.describ = describ;
    }

    public String getDescrib()
    {
        return describ;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("img", getImg())
            .append("describ", getDescrib())
            .append("content", getContent())
            .toString();
    }
}
