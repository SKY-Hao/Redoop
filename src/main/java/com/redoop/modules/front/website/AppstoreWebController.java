package com.redoop.modules.front.website;

import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.component.entity.Component;
import com.redoop.modules.admin.component.service.ComponentService;
import com.redoop.modules.admin.customer.entity.Customer;
import com.redoop.modules.admin.customer.service.CustomerService;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.download.service.DownloadService;
import com.redoop.modules.admin.mess.entity.Mess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 官网Controller
 */
@Controller
@RequestMapping(value = "/front")
public class AppstoreWebController {

    @Autowired
    private ComponentService componentService;
    @Autowired
    private CustomerService customerService;
    private void setStyle(Model model,String state){

        model.addAttribute("appstore","");  //应用组件

        model.addAttribute(state,"on");
    }

    //应用商城页面AppStore
    @RequestMapping(value = "/appstore",method = RequestMethod.GET)
    public String appstore(@RequestParam(value = "type", defaultValue = "0") String type,
                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                           Model model) {
        Page<Component> pageList = componentService.listByType(type,page);
        model.addAttribute("pageList",pageList);
        model.addAttribute("login", "display:none");
        model.addAttribute("type",type);
        model.addAttribute("url","/front/appstore?type="+ type + "&");
        setStyle(model,"appstore");
        return "front/website/appstore";

    }




    /**
     * 应用商城 点击申请时进行判断登录状态  AppStore
     * 2017年8月31日22:56:39
     * @param request
     * @param customer
     * @param model
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/appstore/apply", method= RequestMethod.GET)
    public int apply(HttpServletRequest request, Customer customer,
                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                     Model model, @RequestParam(value = "id") String id) {
        // 状态： 0 表示系统错误 1 表示没有登录 2 登录失败  3 表示没有这个用户  4 表示没有登录权限  5 已经登录  6 去登录  7 去注册 8 注册失败
        //点击申请 一共有  0  1  5这三种状态
        customer = (Customer) request.getSession().getAttribute("customer");
        Page<Component> pageList = componentService.listByType("0",page);
        model.addAttribute("id", id);
        model.addAttribute("pageList", pageList);
        //第一步判断ID是否为空
        if (id == null) {
            return 0;
        }
        //第二步判断是否登录
        if (customer == null) {
            return 6;
        } else {
            return 5;
        }
    }

    /**
     * 应用商城 客户登录 AppStore
     * 2017年9月1日11:56:45
     * @param customer
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/customerLogin", method = RequestMethod.GET)
    public int customerLogin(Customer customer, HttpServletRequest request, HttpSession session) throws Exception {
        //  0 邮箱格式错误    1 邮箱名称错误    2 密码错误  3 登录成功   4 （未激活）请激活再登录
        customer.setLogindate(new Date());
        int s = this.customerService.login(customer);
        if (s==0){//邮箱格式错误
            return 0;
        } else if (s==1){//邮箱名称错误
            return 1;
        }else if(s==2) {//密码错误
            return 2;
        }else if (s==4){//邮箱未激活
            return 4;
        }
        session.setAttribute("customer", customer);
        return 3;//登录成功
    }

    /**
     * 应用商城 根据服务id查询详细信息 AppStore
     * 2017年8月31日23:57:25
     * @param request
     * @param mode
     * @param customer
     * @param id
     * @return
     */
    @RequestMapping(value="/appstore/applyById", method= RequestMethod.GET)
    @ResponseBody
    public Component applyById(HttpServletRequest request, Model mode, Customer customer,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "id") String id){
        customer = (Customer)request.getSession().getAttribute("customer");
        Page<Component> pageList = componentService.listByType("0",page);
        mode.addAttribute("pageList", pageList);
        Component component = null;
        if(customer!=null){
            component = componentService.findById(id);
            return component;
        }else {
            System.out.println("错误，获取服务数据有误！");
        }
        return null;
    }

    /**
     * 应用商城 前端客户注册信息增加 AppStore
     * 2017年9月4日21:50:45
     * huangtianhao
     * @param mode
     * @param customer
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRegiste", method = RequestMethod.POST)
    public boolean addRegiste(Model mode, Customer customer,HttpServletRequest request){
        //域名
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        String code = Uuid.getUuid() + Uuid.getUuid();
        String repassword = request.getParameter("repassword");
        Pattern p=null;
        Matcher m=null;
        String rex = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$";
        p = Pattern.compile(rex);
        m= p.matcher(customer.getPassword());
        //Customer cu_name = customerService.findByUserName(customer.getUsername());
        Customer cu_email = customerService.findByUserEmail(customer.getEmail());
        if (customer==null){
            return false;
        }
       /* if (cu_name != null) {
            return false;
        }*/
        if (cu_email != null) {
            return false;
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
        }
        if (customer.getEmail()==null||"".equals(customer.getEmail())){
            return false;
        }
        try {
            customer.setCode(code);
            customerService.regAdd(customer, repassword,tempContextUrl);
            // System.out.println("注册信息"+customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m.matches();
    }

    /**
     * 应用商城 用户注册成功后激活连接 AppStore
     * @param mode
     * @param customer
     * @param request
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regJH", method = RequestMethod.GET)
    public String  regJH(Model mode, Customer customer,HttpServletRequest request,@RequestParam(value = "code") String code) throws Exception {
        //接收激活码
        code = request.getParameter("code");
        customer = customerService.findByCode(code);
        if(customer!=null){
            //已经查到用户，修改用户状态
            customer.setActivatestate(1);//1:已经激活
            //customer.setCode(null);
            customerService.startActivate(customer.getId());
            request.setAttribute("msg","尊敬的用户,您好!您的邮箱激活成功，请您前往刚刚的页面登录即可...");
            //return "front/website/msg";
        }else {
            //没有查到
            request.setAttribute("msg","尊敬的用户,您好!您的邮箱激活失败，请您检查连接地址是否正确后,请重新激活...");
        }
        return "front/website/msg";
    }

    /**
     * 应用商城 搜索（根据商品的名字进行搜索）AppStore
     * @param model
     * @param name
     * @param session
     * @return
     */
    @RequestMapping(value = "/appstore/select", method = RequestMethod.GET)
    public  String select(Model model,@RequestParam String name,
                          @RequestParam(value = "page", defaultValue = "0") Integer page,HttpSession session){

        Page<Component> pageList=componentService.selectByName(page,"%" + name + "%");

        model.addAttribute("pageList", pageList);
        model.addAttribute("url","/front/appstore/select?name=" + name + "&");
        model.addAttribute("login", "display:none");
        model.addAttribute("name",name);

        return "front/website/appstore";

    }





}