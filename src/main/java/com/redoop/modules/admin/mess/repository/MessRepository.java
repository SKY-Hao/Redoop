package com.redoop.modules.admin.mess.repository;

import com.redoop.modules.admin.mess.entity.Briefing;
import com.redoop.modules.admin.mess.entity.Mess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
public interface MessRepository extends JpaRepository<Mess,String> {


        @Query(value = "FROM Mess a where a.authortime>=?1 and a.authortime<=?2 order by a.authortime desc")
        Page<Mess> findByAuthortimeLike(Date starttime, Date endtime, Pageable pageable);

        /**
         *  简报7天表
         * @return
         */
        @Query(value = "select * from mess where DATE_SUB(CURDATE(), INTERVAL 7 DAY) < date(authortime) order by authortime desc " ,nativeQuery = true)
        //查询上周的信息
        //@Query(value = "select * from mess WHERE YEARWEEK(date_format(authortime,'%Y-%m-%d')) =YEARWEEK(now())-1 order by authortime desc " ,nativeQuery = true)
        List<Mess> list();

        /**
         * 最终简报表（前端用）
         * @return
         */
        @Query(value = "select * from briefing where DATE_SUB(CURDATE(), INTERVAL 7 DAY) < date(authortime) order by authortime desc " ,nativeQuery = true)
        List<Briefing> briefingList();
}
