package com.atjianyi.domain;

import java.util.List;

/**
 * @author 简一
 * @className PageBean
 * @Date 2020/11/9 13:17
 **/
public class PageBean<T> {
    private int totalCount; //总记录数字
    private int totalPage ; //总页数
    private int curPage ; //当前页面
    private int pageSize; //每页展示的条数
    private List<T> mList; //数据集合

    public List<T> getmList() {
        return mList;
    }

    public void setmList(List<T> mList) {
        this.mList = mList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
