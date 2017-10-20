package com.redoop.modules.admin.system.repository;

import com.redoop.modules.admin.system.entity.Picture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 说明：系统图片数据仓库
 * 包名：cn.itweet.modules.admin.system.picture.repository
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/16.
 */
@Repository
public interface PictureRepository extends CrudRepository<Picture,String>{

    @Query(value = "SELECT DISTINCT type FROM picture",nativeQuery = true)
    List<String> findType();

}
