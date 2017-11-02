package com.redoop.modules.admin.news.service;


import com.redoop.common.exception.SystemException;
import com.redoop.common.exception.ValidateException;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.news.entity.New;
import com.redoop.modules.admin.news.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 说明：新闻Service接口
 * 包名：cn.itweet.modules.admin.news
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/2.
 */
public interface NewService {

    /**
     * 新闻保存（有图片附件）
     * @param news
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    void save(News news, MultipartFile attach, String logoPath) throws Exception;

    /**
     * 新闻保存（没有图片附件）
     * @param news
     * @throws Exception
     */
    void save(News news,Mess mess,String tempContextUrl) throws Exception;

    /**
     * 按标题模糊查询新闻 分页
     * @param title
     * @return
     */
    Page<News> selectByTitle(Integer page, String title);

    /**
     * 新闻删除
     * @param id
     */
    void delete(String id);

    /**
     * 按ID查询新闻
     * @param id
     * @return
     */
    News findById(String id);


    /**
     * 新闻列表(网站前端)
     * @return
     */
    //List<New> listNew();
    Page<News> listByState(Integer page);

    /**
     * 新闻列表分页
     * @param page
     * @return
     */
    Page<News> findAll(Integer page);

    /**
     * 取消发布
     * @param id
     */
    void updateState(String id)throws SystemException;;
}
