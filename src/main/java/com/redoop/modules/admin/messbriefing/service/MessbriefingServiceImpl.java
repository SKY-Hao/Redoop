package com.redoop.modules.admin.messbriefing.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.repository.MessRepository;
import com.redoop.modules.admin.messbriefing.entity.Briefing;
import com.redoop.modules.admin.messbriefing.repository.MessbrifingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 说明：最终简报信息ServiceImp
 * 包名：cn.itweet.modules.admin.mess.service
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月23日
 */
@Service
public class MessbriefingServiceImpl implements MessbriefingService {

    @Autowired
    private MessbrifingRepository messbrifingRepository;
    @Autowired
    private MessRepository messRepository;

    @Autowired
    private ConfigProperties configProperties;
    private Sort sort = new Sort(Sort.Direction.DESC,"authortime");


    /**
     * 官网首页显示最近两条信息
     * @return
     */
    @Override
    public List<Briefing> twoList() {
        return messbrifingRepository.twoList();
    }

    /**
     * 保存
     * @param briefing
     * @param ids
     * @throws IOException
     */
    @Override
    @Transactional
    public void lastAdd(Briefing briefing,String[] ids) throws IOException {
        Mess mess = new Mess();
        //调用保存最终简报方法
        if(ids.length>0){
            for (int i=0;i<ids.length;i++){
                mess = messRepository.findOne(ids[i]);
                briefing =saveLast(mess);
                messbrifingRepository.save(briefing);
            }
        }
    }

    /**
     * 保存最终简报方法调用
     * @param mess
     * @return
     * @throws IOException
     */
    private Briefing saveLast(Mess mess) throws IOException {
        Briefing briefing = new Briefing();
        briefing.setAuthortime(mess.getAuthortime());
        briefing.setTablename(mess.getTablename());
        briefing.setAuthor(mess.getAuthor());
        briefing.setTableid(mess.getTableid());
        briefing.setTabletitle(mess.getTitle());
        briefing.setOutline(mess.getOutline());
        briefing.setJumpurl(mess.getJumpurl());
        return briefing;
    }

    /**
     * 最终简报表（前端单独页面用）
     * @return
     */
    @Override
    public List<Briefing> briefingList() {

        List<Briefing> briefingList=messbrifingRepository.briefingList();

        for(Briefing briefing:briefingList){
            String date = briefing.getAuthortime().toString();
            String time=null;
            if(date.length() > 10){
                date = date.substring(0,10);
                time = date.substring(0,10);
            }
            briefing.setDate(time);
        }
        return  briefingList;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id) {
        messbrifingRepository.delete(id);
    }
}
