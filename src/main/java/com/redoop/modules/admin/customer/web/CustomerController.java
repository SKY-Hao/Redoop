package com.redoop.modules.admin.customer.web;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.customer.entity.Customer;
import com.redoop.modules.admin.customer.service.CustomerService;
import java.util.regex.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 说明：客户Controller层
 * 包名：cn.itweet.modules.front.appstore.web
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/12.
 */
@Controller
@RequestMapping(value = "/admin/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 客户信息列表
     *
     * @param mode
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model mode) {
        List<Customer> list = customerService.list();
        mode.addAttribute("list", list);
        return "admin/customer/list";
    }

    /**
     * 客户信息添加页面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return "admin/customer/add";
    }


    /**
     * 客户信息添加
     *
     * @param mode
     * @param customer
     * @param request
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model mode, Customer customer,
                      HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String repassword = request.getParameter("repassword");

        try {
            customerService.add(customer, repassword);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"用户信息添加成功\")</script>");
            return "redirect:/admin/customer/list";
        } catch (SystemException e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", customer);
            return "admin/customer/add";
        }
    }


    /**
     * 客户信息修改页面
     *
     * @param id
     * @param mode
     * @return
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable String id, Model mode) {
        Customer customer = customerService.findById(id);
        mode.addAttribute("form", customer);
        return "admin/customer/edit";
    }

    /**
     * 客户信息修改
     *
     * @param mode
     * @param customer
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model mode, Customer customer,
                       HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String repassword = request.getParameter("repassword");

        try {
            customerService.update(customer, repassword);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"用户信息修改成功\")</script>");
            return "redirect:/admin/customer/list";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", customer);
            return "admin/customer/edit";
        }

    }

    /**
     * 客户信息删除
     *
     * @param id
     * @param mode
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, Model mode, RedirectAttributes redirectAttributes) {
        try {
            customerService.delete(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"用户信息删除成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/customer/list";
    }


    /**
     * 客户登录激活
     *
     * @param id
     * @param mode
     * @return
     */
    @RequestMapping(value = "/startActivate/{id}", method = RequestMethod.GET)
    public String startActivate(@PathVariable String id, Model mode, RedirectAttributes redirectAttributes) {
        try {
            customerService.startActivate(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"用户激活成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/customer/list";
    }


    /**
     * 客户登录禁止
     *
     * @param id
     * @param mode
     * @return
     */
    @RequestMapping(value = "/stopActivate/{id}", method = RequestMethod.GET)
    public String stopActivate(@PathVariable String id, Model mode, RedirectAttributes redirectAttributes) {
        try {
            customerService.stopActivate(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"用户禁止成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/customer/list";
    }

}
