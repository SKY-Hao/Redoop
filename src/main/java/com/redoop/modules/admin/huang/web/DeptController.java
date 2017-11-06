package com.redoop.modules.admin.huang.web;

import com.redoop.modules.admin.huang.entity.Dept;
import com.redoop.modules.admin.huang.entity.Userr;
import com.redoop.modules.admin.huang.service.UserrService;
import com.redoop.modules.admin.mess.entity.Mess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Controller
@RequestMapping(value = "/admin/huang")
public class DeptController {

    @Autowired
    private UserrService userrService;

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public String findAll(Model model){

        List<Userr> pageList= userrService.list();
        model.addAttribute("pageList",pageList);

       // System.out.println("aaaaa===="+userr.getDept().getName());

        model.addAttribute("url","/admin/huang/findAll?");
        return "admin/huang/list";
    }


    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {
        if(id != null){
            Userr userr = userrService.findById(id);
            model.addAttribute("form", userr);
        }
        List<Dept> deptList=userrService.deptList();
         model.addAttribute("deptList",deptList);
        System.out.println("deptList+_----"+deptList.size());
        return "admin/huang/form";
    }



}




