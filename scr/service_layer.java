package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizBook;

/**
 * 电话本Service接口
 * 
 * @author laijh
 * @date 2024-10-25
 */
public interface IBizBookService 
{
    /**
     * 查询电话本
     * 
     * @param bookId 电话本主键
     * @return 电话本
     */
    public BizBook selectBizBookByBookId(Long bookId);

    /**
     * 查询电话本列表
     * 
     * @param bizBook 电话本
     * @return 电话本集合
     */
    public List<BizBook> selectBizBookList(BizBook bizBook);

    /**
     * 新增电话本
     * 
     * @param bizBook 电话本
     * @return 结果
     */
    public int insertBizBook(BizBook bizBook);

    /**
     * 修改电话本
     * 
     * @param bizBook 电话本
     * @return 结果
     */
    public int updateBizBook(BizBook bizBook);

    /**
     * 批量删除电话本
     * 
     * @param bookIds 需要删除的电话本主键集合
     * @return 结果
     */
    public int deleteBizBookByBookIds(Long[] bookIds);

    /**
     * 删除电话本信息
     * 
     * @param bookId 电话本主键
     * @return 结果
     */
    public int deleteBizBookByBookId(Long bookId);
}
