package com.redoop.modules.admin.mess.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.repository.MessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 说明：简报信息ServiceImp
 * 包名：cn.itweet.modules.admin.mess.service
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月23日
 */
@Service
public class MessServiceImpl implements MessService{

    @Autowired
    private MessRepository messRepository;

    @Autowired
    private ConfigProperties configProperties;
    private Sort sort = new Sort(Sort.Direction.DESC,"authortime");
    /**
     * 分页列表
     * @param page
     * @return
     */
   @Override
    public Page<Mess> findAll(Integer page) {
        return messRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize(),sort));
    }

    /**
     * 根据ID进行查询
     * @param id
     * @return
     */
   @Override
    public Mess findById(String id) {
        return messRepository.findOne(id);
    }


    /**
     * 保存|修改
     * @param mess
     */
    @Override
    public void save(Mess mess) {
        if(mess.getId() != null){
            Mess data_c = messRepository.findOne(mess.getId());//id
            mess.setAuthor(data_c.getAuthor());//添加作者
            mess.setAuthortime(data_c.getAuthortime());

        }else{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            mess.setAuthor(user.getUsername());
        }

        messRepository.save(mess);
    }

    /**
     * 删除
     * @param id
     * @throws SystemException
     */
    @Override
    public void delete(String id) throws SystemException {
        messRepository.delete(id);
    }

    /**
     * 前端列表-暂时没用
     * @return
     */
    @Override
    public List<Mess> list() {
        return messRepository.list();
    }

    /**
     * 根据日期查询
     * @param starttime
     * @param endtime
     * @param page
     * @return
     * @throws ParseException
     */
    @Override
    public Page<Mess> selectByTime(String starttime, String endtime,Integer page) throws ParseException {

        Date start=null;
        Date end=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        start = simpleDateFormat.parse(starttime);
        end = simpleDateFormat.parse(endtime);

        return messRepository.findByAuthortimeLike(start,end,BasePageBuilder.create(page,configProperties.getPageSize()));
    }



}
