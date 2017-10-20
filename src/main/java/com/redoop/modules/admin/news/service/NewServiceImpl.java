package com.redoop.modules.admin.news.service;


import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.common.utils.HtmlUtil;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.news.entity.New;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.news.entity.PageUtil;
import com.redoop.modules.admin.news.repository.NewRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 说明：新闻Service实现类
 * 包名：cn.itweet.modules.admin.news
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/2.
 */
@Service
public class NewServiceImpl  implements NewService{

    @Autowired
    private NewRepository newRepository;
    @Autowired
    private ConfigProperties configProperties;

    private Sort sort = new Sort(Sort.Direction.DESC,"date");

    /**
     * 新闻保存（有图片附件）
     * @param news
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    @Override
    public void save(News news, MultipartFile attach, String logoPath) throws SystemException {

        if (news.getTitle() == null || "".equals(news.getTitle())) {
            throw new SystemException("<script>toastr.error(\"新闻标题不能为空\")</script>");
        }

        if(news.getId() != null){
            News date_news = newRepository.findOne(news.getId());
            news.setPublisher(date_news.getPublisher());
            news.setDate(date_news.getDate());
            news.setState(date_news.getState());

            if(attach.isEmpty()){
                news.setPicpath(date_news.getPicpath());
            }else{
                try {
                    news = uploadPic(news,attach,logoPath);
                    DeleteUtils.deletePic(logoPath + date_news.getPicpath());
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"新闻Logo上传失败\")</script>");
                }
            }
        }else{
            if(attach.isEmpty()){
                throw new SystemException("<script>toastr.error(\"新闻Logo不能为空\")</script>");
            }else{
                try {
                    news = uploadPic(news,attach,logoPath);
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"新闻Logo上传失败\")</script>");
                }
            }
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            news.setPublisher(user.getUsername());
            news.setDate(new Date());
            news.setState(0);
        }

        newRepository.save(news);
    }

    /**
     * 新闻保存（没有图片附件）
     * @param news
     * @throws SystemException
     */
    @Override
    public void save(News news) throws SystemException {
        newRepository.save(news);
    }

    /**
     * 图片上传
     * @param news
     * @param attach
     * @param logoPath
     * @return
     * @throws IOException
     */
    private News uploadPic(News news, MultipartFile attach,String logoPath) throws IOException {
        logoPath = logoPath + configProperties.getUploadSuffix();

        File filePath=new File(logoPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        String picNameOld = attach.getOriginalFilename();
        String picType = picNameOld.substring(picNameOld.lastIndexOf("."),picNameOld.length());
        String picNameNew = Uuid.getUuid() + picType;

        //最终文件名
        File realFile=new File(logoPath + File.separator + picNameNew);
        FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
        news.setPicpath(configProperties.getUploadSuffix() + picNameNew);

        return news;
    }

    /**
     * 按标题模糊查询新闻 分页
     * @param page
     * @param title
     * @return
     */
    @Override
    public Page<News> selectByTitle(Integer page, String title) {
        return newRepository.findByTitleLike(title,BasePageBuilder.create(page,configProperties.getPageSize(),sort));
    }

    /**
     * 新闻列表(网站前端)
     * @return
     */
    @Override
    public List<New> listNew() {
        List<New> newList = new ArrayList<New>();
        List<News> newsList =  newRepository.findByStatusList();

        for(News news : newsList){
            New oneNew = new New();

            oneNew.setId(news.getId());
            oneNew.setTitle(news.getTitle());

            String date = news.getDate().toString();

            String year = null;
            String month = null;
            String day = null;

            if(date.length() < 10){
                date = new Date().toString().substring(0,10);
                year = date.substring(0,4);
                month = date.substring(5,7);
                day = date.substring(8,10);
            }else{
                date = date.substring(0,10);
                year = date.substring(0,4);
                month = date.substring(5,7);
                day = date.substring(8,10);
            }
            oneNew.setYear(year);
            oneNew.setMonth(month);
            oneNew.setDay(day);

            oneNew.setPicPath(news.getPicpath());
            String content = news.getContent();
            content = HtmlUtil.delHTMLTag(content);
            if(content.length() > 200){
                oneNew.setContent(content.substring(0,200));
            }else{
                oneNew.setContent(content);
            }
            newList.add(oneNew);
        }
        return newList;
    }
/*
    public Page<New> listNew(Integer page) {

        List<New> newList = new ArrayList<New>();   //前端new

       // List<String> n = new ArrayList<String>();

        Page<News> newsList = null;                 //新闻实体类news
        //PageUtil pu = new PageUtil();
        //pu.setPagesize(5);
       // pu.setPageData(newsList.getContent());

        newsList= newRepository.findByStatusList(BasePageBuilder.create(page,configProperties.getPageSize(),sort));

        for(News news : newsList){
            New oneNew = new New();

            oneNew.setId(news.getId());
            oneNew.setTitle(news.getTitle());

            String date = news.getDate().toString();

            String year = null;
            String month = null;
            String day = null;

            if(date.length() < 10){
                date = new Date().toString().substring(0,10);
                year = date.substring(0,4);
                month = date.substring(5,7);
                day = date.substring(8,10);
            }else{
                date = date.substring(0,10);
                year = date.substring(0,4);
                month = date.substring(5,7);
                day = date.substring(8,10);
            }
            oneNew.setYear(year);
            oneNew.setMonth(month);
            oneNew.setDay(day);

            oneNew.setPicPath(news.getPicpath());
            String content = news.getContent();
            content = HtmlUtil.delHTMLTag(content);
            if(content.length() > 200){
                oneNew.setContent(content.substring(0,200));
            }else{
                oneNew.setContent(content);
            }
            newList.add(oneNew);
        }
        return  newList;
    }
*/

    /**
     * 新闻删除
     * @param id
     */
    @Override
    public void delete(String id) {
        newRepository.delete(id);
    }

    /**
     * 按ID查询新闻
     * @param id
     * @return
     */
    @Override
    public News findById(String id) {
        return newRepository.findOne(id);
    }

    /**
     * 新闻列表分页
     * @param page
     * @return
     */
    @Override
    public Page<News> findAll(Integer page) {
        return newRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize(),sort));
    }
}
