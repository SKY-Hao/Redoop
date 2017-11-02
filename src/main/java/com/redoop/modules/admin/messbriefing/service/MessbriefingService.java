package com.redoop.modules.admin.messbriefing.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.messbriefing.entity.Briefing;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 说明：最终简报信息Service
 * 包名：cn.itweet.modules.admin.mess.service
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月23日
 */
public interface MessbriefingService {

    /**
     * 官网首页显示最近两条信息
     * @return
     */
    List<Briefing> twoList();

    /**
     * 生成最终简报保存
     * @param briefing
     * @return
     */
    void lastAdd(Briefing briefing,String[] ids) throws IOException;

    /**
     * 最终简报表（前端单独页面用）
     * @return
     */
    List<Briefing> briefingList();


}
