package com.redoop.modules.admin.license.repository;

import com.redoop.modules.admin.license.entity.License;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 说明：注册数据仓库
 * 包名：cn.itweet.modules.admin.license
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Repository
public interface LicenseRepository extends CrudRepository<License, Integer> {


    /**
     * 根据Mac、IP、Email、Project、Company查询注册记录
     * @param mac
     * @param ip
     * @param email
     * @param project
     * @param company
     * @return
     */
    @Query(value = "select * from license l  where l.mac = :mac AND l.ip = :ip AND l.email = :email AND l.project = :project AND l.company = :company",nativeQuery = true)
    public License findByCustomerInformation(@Param("mac") String mac,@Param("ip") String ip,@Param("email") String email,@Param("project") String project,@Param("company") String company);

    /**
     *
     * 根据公司名称模糊查询
     */
    @Query(value = "select * from license l  where l.company like CONCAT('%',:companyName,'%')",nativeQuery = true)
    public List<License> getByCompany(@Param("companyName") String companyName);

}
