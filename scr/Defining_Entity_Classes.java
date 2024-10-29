package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电话本对象 biz_book
 * 
 * @author laijh
 * @date 2024-10-25
 */
public class BizBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 电话本ID */
    private Long bookId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String bookName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String bookPhone;

    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }
    public void setBookName(String bookName) 
    {
        this.bookName = bookName;
    }

    public String getBookName() 
    {
        return bookName;
    }
    public void setBookPhone(String bookPhone) 
    {
        this.bookPhone = bookPhone;
    }

    public String getBookPhone() 
    {
        return bookPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bookId", getBookId())
            .append("bookName", getBookName())
            .append("bookPhone", getBookPhone())
            .append("createTime", getCreateTime())
            .toString();
    }
}
