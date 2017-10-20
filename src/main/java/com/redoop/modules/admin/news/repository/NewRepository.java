package com.redoop.modules.admin.news.repository;

import com.redoop.modules.admin.news.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 说明：
 * 包名：cn.itweet.modules.admin.news.repository
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/2.
 */
@Repository
@Transactional
public interface NewRepository  extends JpaRepository<News,String> {

    @Query(value = "from News where state=1 order by date desc")
    List<News> findByStatusList();
   /* @Query(value = "FROM News a where a.state=1 order by date desc")
    Page<News> findByStatusList(Pageable pageable);
*/

    Page<News> findByTitleLike(String title, Pageable pageable);

}
