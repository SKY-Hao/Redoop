package com.redoop.common.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 说明：
 * 创建人：Itdeer
 * 创建时间：2017-09-25 下午12:02.
 */
public class BasePageBuilder {

    /**
     * 创建分页构造方法(三个参数)
     * @param page
     * @param size
     * @param sort
     * @return
     */
    public static Pageable create(int page, int size, Sort sort){
        return new PageRequest(page,size,sort);
    }

    /**
     * 创建分页构造方法(两个参数)
     * @param page
     * @param size
     * @return
     */
    public static Pageable create(int page,int size){
        return new PageRequest(page,size);
    }
}
