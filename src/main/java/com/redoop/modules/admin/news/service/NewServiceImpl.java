package com.redoop.modules.admin.news.service;


import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.common.utils.HtmlUtil;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.repository.MessRepository;
import com.redoop.modules.admin.news.entity.News;
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
import java.util.Date;

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

    @Autowired
    private MessRepository messRepository;
    private Sort sort = new Sort(Sort.Direction.DESC,"date");

    /**
     * 新闻保存（有图片附件）
     * @param news
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    @Override
    public void save(News news, MultipartFile attach, String logoPath) throws Exception {

        if (news.getTitle() == null || "".equals(news.getTitle())) {
            throw new SystemException("<script>toastr.error(\"新闻标题不能为空\")</script>");
        }

        if(news.getId() != null){
            News date_news = newRepository.findOne(news.getId());
            news.setPublisher(date_news.getPublisher());
            //news.setDate(date_news.getDate());
            news.setState(date_news.getState());

            if(attach.isEmpty()){
                news.setPicpath(date_news.getPicpath());
            }else{
                try {
                    news = uploadPic(news,attach,logoPath);
                    DeleteUtils.deletePic(logoPath + date_news.getPicpath());
                } catch (Exception e) {
                    throw new SystemException("<script>toastr.error(\"新闻Logo上传失败\")</script>");
                }
            }
            Mess mess=new Mess();
            news =saveMess(news,mess);
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
    public void save(News news,Mess mess) throws Exception {
        news =saveMess(news,mess);
        newRepository.save(news);
    }

    /**
     * 保存简报日志表
     * @param news
     * @param mess
     * @return
     * @throws IOException
     */
    private News saveMess(News news,Mess mess) throws IOException {
        mess.setAuthortime(new Date());
        mess.setTablename(News.class.getSimpleName());
        mess.setTableid(news.getId());
        mess.setAuthor(news.getPublisher());
        mess.setTitle(news.getTitle());
        mess.setOutline(news.getOutline());
        messRepository.save(mess);
        return news;
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
    public Page<News> listByState(Integer page) {
        Page<News> newsList =  newRepository.listByState(BasePageBuilder.create(page,configProperties.getPageSize(),sort));
        for(News news : newsList){
            String date = news.getDate().toString();

            String time=null;
            if(date.length() > 10){

                date = date.substring(0,10);
                time = date.substring(0,10);
            }
            news.setDate(time);

            String content = news.getContent();
            content = HtmlUtil.delHTMLTag(content);
            if(content.length() > 200){
                news.setContent(content.substring(0,200));
            }else{
                news.setContent(content);
            }
        }
        return newsList;
    }

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

    @Override
    public void updateState(String id) throws SystemException {
         newRepository.updateState(id);
    }
}
