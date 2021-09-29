package com.brisk.farm_serve.util;

import com.brisk.farm_serve.pojo.bo.PageRequest;
import com.brisk.farm_serve.pojo.dto.PageResult;
import com.github.pagehelper.PageInfo;

public class PageUtils {

    /**
     * 将分页信息封装到统一的接口.
     * 将PageInfo 包装的数据转换到PageResult里
     * @param pageRequest
     * @param
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
