package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BizBook;
import com.ruoyi.system.service.IBizBookService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 电话本Controller
 * 
 * @author laijh
 * @date 2024-10-25
 */
@RestController
@RequestMapping("/system/book")
public class BizBookController extends BaseController
{
    @Autowired
    private IBizBookService bizBookService;

    /**
     * 查询电话本列表
     */
    @PreAuthorize("@ss.hasPermi('system:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizBook bizBook)
    {
        startPage();
        List<BizBook> list = bizBookService.selectBizBookList(bizBook);
        return getDataTable(list);
    }

    /**
     * 导出电话本列表
     */
    @PreAuthorize("@ss.hasPermi('system:book:export')")
    @Log(title = "电话本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizBook bizBook)
    {
        List<BizBook> list = bizBookService.selectBizBookList(bizBook);
        ExcelUtil<BizBook> util = new ExcelUtil<BizBook>(BizBook.class);
        util.exportExcel(response, list, "电话本数据");
    }

    /**
     * 获取电话本详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:query')")
    @GetMapping(value = "/{bookId}")
    public AjaxResult getInfo(@PathVariable("bookId") Long bookId)
    {
        return success(bizBookService.selectBizBookByBookId(bookId));
    }

    /**
     * 新增电话本
     */
    @PreAuthorize("@ss.hasPermi('system:book:add')")
    @Log(title = "电话本", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizBook bizBook)
    {
        return toAjax(bizBookService.insertBizBook(bizBook));
    }

    /**
     * 修改电话本
     */
    @PreAuthorize("@ss.hasPermi('system:book:edit')")
    @Log(title = "电话本", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizBook bizBook)
    {
        return toAjax(bizBookService.updateBizBook(bizBook));
    }

    /**
     * 删除电话本
     */
    @PreAuthorize("@ss.hasPermi('system:book:remove')")
    @Log(title = "电话本", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bookIds}")
    public AjaxResult remove(@PathVariable Long[] bookIds)
    {
        return toAjax(bizBookService.deleteBizBookByBookIds(bookIds));
    }
}
