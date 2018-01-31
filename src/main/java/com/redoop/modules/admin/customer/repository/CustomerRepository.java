package com.redoop.modules.admin.customer.repository;

import com.redoop.modules.admin.customer.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 说明：客户信息数据仓库接口
 * 包名：cn.itweet.modules.admin.customer.repository
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/12.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {


    /**
     * 客户登录激活
     *
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET activatestate = 1 WHERE id = :id")
    public void startActivate(@Param("id") String id);

    /**
     * 客户登录禁止
     *
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET activatestate = 0 WHERE id = :id")
    public void stopActivate(@Param("id") String id);



    /**
     * 客户信息按邮箱精确查询
     *
     * @param email
     * @return
     */
    @Query(value = "FROM Customer WHERE email = :email")
    public Customer findByUserEmail(@Param("email") String email);

    @Query(value = "FROM Customer WHERE ip = :ip")
    Customer findByIp(@Param("ip") String ip);


    /**
     * 客户信息按用户名称精确查询
     *
     * @param username
     * @return
     */
    @Query(value = "FROM Customer WHERE username = :username")
    public Customer findByUserName(@Param("username") String username);

    /**
     * 客户信息按激活状态查询
     *
     * @param activatestate
     * @return
     */
    @Query(value = "FROM Customer WHERE activatestate = :activatestate")
    public List<Customer> findByActivatestate(@Param("activatestate") Integer activatestate);

    /**
     * 根据激活码查询用户
     * 2017年9月4日22:10:20
     * @param code
     * @return
     */
    @Query(value = "FROM Customer WHERE code = :code")
    public Customer findByCode(@Param("code") String code);


}
