package com.redoop.modules.admin.messbriefing.repository;

import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.messbriefing.entity.Briefing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 说明：Repository
 * 包名：cn.itweet.modules.admin.mess.Repository
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月23日
 */
@Repository
public interface MessbrifingRepository extends JpaRepository<Briefing,String> {


        /**
         * 最终简报表（前端用）
         * @return
         */
        @Query(value = "select * from briefing where DATE_SUB(CURDATE(), INTERVAL 7 DAY) < date(authortime) order by authortime desc " ,nativeQuery = true)
        List<Briefing> briefingList();

}
