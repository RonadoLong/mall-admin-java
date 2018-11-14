package com.shop.common.utils;

import lombok.Data;

@Data
public class PageUtils {

    private int pageNum;
    private int pageSize;

    public PageUtils(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public static PageUtils generatePage(int total, int pageNum, int pageSize){
        PageUtils pageUtils = new PageUtils(pageNum, pageSize);

        pageUtils.pageNum = pageNum;
        pageUtils.pageSize = pageSize;

        if (pageUtils.pageNum == 0){
            pageUtils.pageNum = 1;
        }

        if (pageUtils.pageSize == 0){
            pageUtils.pageSize = 10;
        }

        pageUtils.pageNum = (pageUtils.pageNum - 1)* pageUtils.pageSize;
        if (total == 0 || total <= pageUtils.pageNum){
            return null;
        }

        return pageUtils;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
