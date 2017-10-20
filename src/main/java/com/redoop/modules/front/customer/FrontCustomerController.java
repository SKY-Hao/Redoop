package com.redoop.modules.front.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 说明： 前端客户Controller
 * 创建人：Itdeer
 * 创建时间：2017-10-12 下午2:45.
 */

@Controller
public class FrontCustomerController {

    /**
     * 前端客户请求登录页面
     * @return
     */
    @RequestMapping(value = "/customer/login",method = RequestMethod.GET)
    public String login(){
        return "front/customer/login";
    }

    /**
     * 前端客户请求登录操作
     * @param model
     * @return
     */
    @RequestMapping(value = "/customer/login",method = RequestMethod.POST)
    public String login(Model model){

        return "";
    }

    @RequestMapping(value = "/customer/logout",method = RequestMethod.GET)
    public String logout(){
        return "";
    }

    @RequestMapping(value = "/customer/register",method = RequestMethod.GET)
    public String register(){
        return "front/customer/register";
    }

    @RequestMapping(value = "/customer/register",method = RequestMethod.POST)
    public String register(Model model){
        return "";
    }

}
