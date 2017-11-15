package com.redoop.modules.admin.ceshi.web;

import com.redoop.modules.admin.ceshi.entity.Dept;
import com.redoop.modules.admin.ceshi.entity.Emp;
import com.redoop.modules.admin.ceshi.service.DeptService;
import com.redoop.modules.admin.ceshi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */
@Controller
@RequestMapping(value = "/admin/ceshi")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(Model mode) {

        List<Emp> list= empService.list();
        mode.addAttribute("list",list);

        return "admin/ceshi/list";
    }


    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {

        if(id != null){
            Emp emp = empService.findById(id);
            model.addAttribute("form", emp);
        }
        List<Dept> deptList= deptService.list();
        model.addAttribute("deptList",deptList);
        //System.out.println("dept===="+deptList.toString());
        return "admin/ceshi/form";
    }





}
