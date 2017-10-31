package com.redoop.modules.admin.messbriefing.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.messbriefing.entity.Briefing;
import com.redoop.modules.admin.messbriefing.repository.MessbrifingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

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
    private ConfigProperties configProperties;
    private Sort sort = new Sort(Sort.Direction.DESC,"authortime");

    /**
     * 最终简报表（前端用）
     * @return
     */
    @Override
    public List<Briefing> briefingList() {
        return messbrifingRepository.briefingList();
    }

    @Override
    public void lastAdd(Briefing briefing,Mess mess) throws IOException {
        briefing =saveLast(mess,briefing);
        messbrifingRepository.save(briefing);
    }

    /**
     * 保存最终简报方法调用
     * @param briefing
     * @param mess
     * @return
     * @throws IOException
     */
    private Briefing saveLast(Mess mess, Briefing briefing) throws IOException {
        briefing.setAuthortime(mess.getAuthortime());
        briefing.setTablename(mess.getTablename());
        briefing.setAuthor(mess.getAuthor());
        briefing.setTableid(mess.getTableid());
        briefing.setTabletitle(mess.getTitle());
        briefing.setOutline(mess.getOutline());
        //messbrifingRepository.save(briefing);
        return briefing;
    }
}
