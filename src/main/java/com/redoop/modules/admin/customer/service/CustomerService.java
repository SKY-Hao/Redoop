package com.redoop.modules.admin.customer.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.customer.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 说明：客户信息Service接口层
 * 包名：cn.itweet.tea.admin.customer.service
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/12.
 */
public interface CustomerService {

    /**
     * 客户信息列表
     *
     * @return
     */
    public List<Customer> list();

    /**
     * 客户信息添加
     *
     * @param customer
     * @param repassword
     * @throws SystemException
     */
    public void add(Customer customer, String repassword) throws SystemException;

    /**
     * 前台客户注册添加
     * @param customer
     * @param repassword
     * @return
     * @throws Exception
     */
    public Boolean regAdd(Customer customer, String repassword,String tempContextUrl) throws Exception;


    /**
     * 激活码查询
     * 2017年9月4日22:09:58
     *
     * @param code
     * @return
     */
    public  Customer findByCode(String code);

    /**
     * 客户信息修改
     *
     * @param customer
     * @param repassword
     * @throws SystemException
     */
    public void update(Customer customer, String repassword) throws Exception;

    /**
     * 客户信息按ID删除
     *
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException;

    /**
     * 客户登录（前端调用）
     *
     * @param customer
     * @throws SystemException
     */
    public int login(Customer customer) throws SystemException;

    /**
     * 客户信息登录激活
     *
     * @param id
     * @throws SystemException
     */
    public void startActivate(String id) throws SystemException;

    /**
     * 客户登录禁止
     *
     * @param id
     * @throws SystemException
     */
    public void stopActivate(String id) throws SystemException;

    /**
     * 客户信息按ID精确查询
     *
     * @param id
     * @return
     */
    public Customer findById(String id);

    /**
     * 客户信息按名称模糊查询
     *
     * @param username
     * @return
     */
    public List<Customer> findByName(String username);

    /**
     * 客户信息按公司名称模糊查询
     *
     * @param companyname
     * @return
     */
    public List<Customer> findByCompanyname(String companyname);

    /**
     * 客户信息按邮箱模糊查询
     *
     * @param email
     * @return
     */
    public List<Customer> findByEmail(String email);

    /**
     * 客户信息按激活状态查询
     *
     * @param activatestate
     * @return
     */
    public List<Customer> findByActivatestate(int activatestate);

    /**
     * 前台注册验证邮箱是否唯一
     * @param email
     * @return
     */
    public Customer findByUserEmail(String email);

    /**
     * 前台验证注册用户名是否唯一
     * @param username
     * @return
     */
    public Customer findByUserName(String username);


    Customer saveCustomer(Customer customer, HttpServletRequest request);

    public  int findByIP(Customer customer, HttpServletRequest request);
}
