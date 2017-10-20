package com.redoop.modules.admin.news.entity;

import javax.servlet.jsp.tagext.PageData;
import java.util.List;

/**
 * Created by Administrator on 2017/9/28.
 */
public class PageUtil {

    private int pagesize;

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    private List<News> PageData;


    public List<News> getPageData() {
        return PageData;
    }

    public void setPageData(List<News> pageData) {
        PageData = pageData;
    }
}
