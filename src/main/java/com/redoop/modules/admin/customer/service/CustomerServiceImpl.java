package com.redoop.modules.admin.customer.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.EmailUtils;
import com.redoop.common.utils.IpUtilS;
import com.redoop.modules.admin.customer.entity.Customer;
import com.redoop.modules.admin.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 说明：客户信息Service实现类层
 * 包名：cn.itweet.tea.admin.customer.service
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/12.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 客户信息列表
     *
     * @return
     */
    public List<Customer> list() {
        return (List<Customer>) customerRepository.findAll();
    }


    /** 客户信息添加
     * 2017年8月23日13:04:43
     * @param customer
     * @param repassword
     * @throws SystemException
     */
    public void add(Customer customer, String repassword) throws SystemException {

        if (customer.getUsername() == null || "".equals(customer.getUsername())){
            throw new SystemException("<script>toastr.error(\"用户名称不能为空\")</script>");
        }

        if (customer.getPhonenumber() == null || "".equals(customer.getPhonenumber())
                ||!customer.getPhonenumber().matches("^\\d{11}$")) {
            throw new SystemException("<script>toastr.error(\"用户电话不能为空并且为11位\")</script>");
        }

        if (customer.getEmail() == null || "".equals(customer.getEmail())
                ||!customer.getEmail().matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,3}$")) {
            throw new SystemException("<script>toastr.error(\"用户邮箱不能为空并且为通用邮箱格式\")</script>");
        }

        if (customer.getCompanyname() == null || "".equals(customer.getCompanyname())) {
            throw new SystemException("<script>toastr.error(\"公司名称不能为空\")</script>");
        }

        if (customer.getPassword() == null || "".equals(customer.getPassword())) {
            throw new SystemException("<script>toastr.error(\"密码不能为空\")</script>");
        }

        if (repassword == null || "".equals(repassword)) {
            throw new SystemException("<script>toastr.error(\"密码确认不能为空\")</script>");
        }

        if (!customer.getPassword().equals(repassword)) {
            throw new SystemException("<script>toastr.error(\"两次密码不一致\")</script>");
        }

        Customer cu_name = findByUserName(customer.getUsername());
        if (cu_name != null) {
            throw new SystemException("<script>toastr.error(\"用户名已经存在\")</script>");
        }
        Customer cu_email = findByUserEmail(customer.getEmail());
        if (cu_email != null) {
            throw new SystemException("<script>toastr.error(\"邮箱已经存在\")</script>");
        }

        customer.setRegisterdate(new Date());
        customerRepository.save(customer);
    }


    /**
     * 前台客户注册
     * 2017年9月4日16:11:26
     * @param customer
     * @param repassword
     * @return
     * @throws SystemException
     */
    public Boolean regAdd(Customer customer, String repassword,String tempContextUrl) throws Exception {

        if (customer.getUsername() == null || "".equals(customer.getUsername())){
            return false;
        }
        if (customer.getPhonenumber() == null || "".equals(customer.getPhonenumber())
                ||!customer.getPhonenumber().matches("^[\\d]{11}$")) {
            return false;
        }
        if (customer.getEmail() == null || "".equals(customer.getEmail())
                ||!customer.getEmail().matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
            return false;
        }
        if (customer.getCompanyname() == null || "".equals(customer.getCompanyname())) {
            return  false;
        }
        if (customer.getPassword() == null || "".equals(customer.getPassword())
                ||!customer.getPassword().matches("^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$")) {
            return false;
        }
        if (repassword == null || "".equals(repassword)) {
            return false;
        }
        if (!customer.getPassword().equals(repassword)) {
            return false;
        }else {
            customer.setRegisterdate(new Date());
            customerRepository.save(customer);
            //发邮件
            EmailUtils eu = new EmailUtils();
            eu.sendMail(javaMailSender,configProperties.getMailFrom(),customer.getEmail(),configProperties.getMailSubject(),
                    "来自红象云腾技术系统有限公司的激活邮件:\n激活请点击连接: \n"+tempContextUrl+"/front/regJH?code="+customer.getCode()+"\n如果单击链接没有反应，请将链接地址复制到浏览器窗口中，或直接输入链接。\n致敬！\n红象云腾");
        }
        return false;
    }

    /**
     * 激活码查询
     * 2017年9月4日22:10:06
     * 黄天浩
     * @param code
     * @return
     */
    @Override
    public Customer findByCode(String code) {
        return customerRepository.findByCode(code);
    }



    /**
     * 客户信息更新
     *
     * @param customer
     * @param repassword
     * @throws SystemException
     */
    public void update(Customer customer, String repassword) throws Exception {

        if (customer.getUsername() == null || "".equals(customer.getUsername())) {
            throw new SystemException("<script>toastr.error(\"用户名称不能为空\")</script>");
        }

        if (customer.getPhonenumber() == null || "".equals(customer.getPhonenumber())
                ||!customer.getPhonenumber().matches("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$")) {
            throw new SystemException("<script>toastr.error(\"用户电话不能为空并且为11位\")</script>");
        }

        if (customer.getEmail() == null || "".equals(customer.getEmail())
                ||!customer.getEmail().matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
            throw new SystemException("<script>toastr.error(\"用户邮箱不能为空并且为通用邮箱格式\")</script>");
        }

        if (customer.getCompanyname() == null || "".equals(customer.getCompanyname())) {
            throw new SystemException("<script>toastr.error(\"公司名称不能为空\")</script>");
        }

        if (customer.getPassword() == null || "".equals(customer.getPassword())) {
            throw new SystemException("<script>toastr.error(\"密码不能为空\")</script>");
        }

        if (repassword == null || "".equals(repassword)) {
            throw new SystemException("<script>toastr.error(\"密码确认不能为空\")</script>");
        }

        if (!customer.getPassword().equals(repassword)) {
            throw new SystemException("<script>toastr.error(\"两次密码不一致\")</script>");
        }

        Customer findCustomer = customerRepository.findOne(customer.getId());
        customer.setRegisterdate(findCustomer.getRegisterdate());
        customer.setLogindate(findCustomer.getLogindate());

        customerRepository.save(customer);
    }



    /**
     * 客户信息按ID删除
     *
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException {
        try {
            customerRepository.delete(id);
        } catch (Exception e) {
            throw new SystemException("<script>toastr.error(\"客户信息删除失败\")</script>");
        }
    }

    /**
     * 客户登录激活
     *
     * @param id
     * @throws SystemException
     */
    public void startActivate(String id) throws SystemException {
        customerRepository.startActivate(id);
    }

    /**
     * 客户登录禁止
     *
     * @param id
     * @throws SystemException
     */
    public void stopActivate(String id) throws SystemException {
        customerRepository.stopActivate(id);
    }

    /**
     * 客户信息按ID查询
     *
     * @param id
     * @return
     */
    public Customer findById(String id) {
        return customerRepository.findOne(id);
    }

    /**
     * 客户信息按用户名称精确查询
     *
     * @param username
     * @return
     */
    public Customer findByUserName(String username) {
        return customerRepository.findByUserName(username);
    }


    /**
     * 客户信息按邮箱精确查询
     *
     * @param email
     * @return
     */
    public Customer findByUserEmail(String email) {
        return customerRepository.findByUserEmail(email);
    }

    /**
     * 客户信息按激活状态查询
     *
     * @param activatestate
     * @return
     */
    public List<Customer> findByActivatestate(int activatestate) {
        return customerRepository.findByActivatestate(activatestate);
    }

    /**
     * 客户登录
     *
     * @param customer
     * @throws SystemException
     */
    public int login(Customer customer) throws SystemException {

        //  0 邮箱格式错误    1 邮箱名称错误    2 密码错误  3 登录成功   4 （未激活）请激活再登录

        if (customer.getEmail() == null || "".equals(customer.getEmail())
                ||!customer.getEmail().matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
            return 0;
        }
        Customer cus = customerRepository.findByUserEmail(customer.getEmail());
        if(cus == null){
            return 1;
        }else if(!customer.getPassword().equals(cus.getPassword())){
            return 2;
        }else if (cus.getActivatestate()!=1){
            return 4;
        }
        return 3;
    }
    @Override
    public int findByIP(Customer customer, HttpServletRequest request) {
        //0:没有获取到用户IP,让用户填写信息,并获取IP   1:获取到IP,数据库并有这个IP     2.

       // System.out.println("customer.getIp()1111======"+customer.getIp());

        customer.setIp(IpUtilS.getIpAddress(request));

        //System.out.println("customer.getIp()2222======"+customer.getIp());

        Customer cus= customerRepository.findByIp(customer.getIp());
        //System.out.println("cus====="+cus);

        if(cus==null){
            return 0;
        }
       // System.out.println("cus.getIP====="+cus.getIp());


        return 1;
    }




    /**
     * 客户信息按用户名称模糊查询
     *
     * @param username
     * @return
     */
    public List<Customer> findByName(String username) {
        return null;
    }

    /**
     * 客户信息按公司名称模糊查询
     *
     * @param companyname
     * @return
     */
    public List<Customer> findByCompanyname(String companyname) {
        return null;
    }

    /**
     * 客户信息按邮箱模糊查询
     *
     * @param email
     * @return
     */
    public List<Customer> findByEmail(String email) {
        return null;
    }


    @Override
    public Customer saveCustomer(Customer customer, HttpServletRequest request) {
        customer.setIp(IpUtilS.getIpAddress(request));
        customer.setRegisterdate(new Date());
        return customerRepository.save(customer);
    }


}
