package com.redoop.modules.admin.solution.service;


import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.repository.MessRepository;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.solution.entity.Solution;
import com.redoop.modules.admin.solution.repository.SolutionRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 说明：新闻Service实现类
 * 包名：cn.itweet.tea.admin.Solution
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间：2017年10月16日16:20:38
 */
@Service
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private MessRepository messRepository;
    private Sort sort = new Sort(Sort.Direction.DESC,"authortime");


    /**
     * 后台列表
     * @param page
     * @return
     */
    @Override
    public Page<Solution> findAll(Integer page) {
        return solutionRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize(),sort));
    }

    
    @Override
    public Solution findById(String id) {
        return solutionRepository.findOne(id);
    }

    /**
     * 方案|案例添加及修改
     * @param solution
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    @Override
    public void save(Solution solution, MultipartFile attach, String logoPath)throws SystemException {

        if (solution.getTitle() == null || "".equals(solution.getTitle())) {
            throw new SystemException("<script>toastr.error(\"标题不能为空\")</script>");
        }

        if(solution.getId() != null){
            Solution data_c = solutionRepository.findOne(solution.getId());//id
            solution.setAuthor(data_c.getAuthor());//作者
            solution.setSolutionpicnamne(data_c.getSolutionpicnamne());//方案及案例LOGO
            solution.setSolutionpic(data_c.getSolutionpic());//方案及案例名称
            solution.setAuthortime(new Date());//发布时间
            solution.setState(1);//发布状态 0:发布 1:不发布

            if(attach.isEmpty()){
                solution.setSolutionpic(data_c.getSolutionpic());
            }else{
                try {
                    solution = uploadPic(solution,attach,logoPath);
                    DeleteUtils.deletePic(logoPath + data_c.getSolutionpic());
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"方案|案例Logo上传失败\")</script>");
                }
            }

        }else{
            if(attach.isEmpty()){
                throw new SystemException("<script>toastr.error(\"方案|案例Logo不能为空\")</script>");
            }else{
                try {
                    solution = uploadPic(solution,attach,logoPath);
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"方案|案例Logo上传失败\")</script>");
                }
            }
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            solution.setAuthor(user.getUsername());
            solution.setAuthortime(new Date());//发布时间
            solution.setState(1);
        }

        solutionRepository.save(solution);
    }


    /**
     * 方案及案例LOGO上传
     * @param solution
     * @param attach
     * @param logoPath
     * @return
     * @throws IOException
     */
    private Solution uploadPic(Solution solution, MultipartFile attach, String logoPath) throws IOException {
        logoPath = logoPath + configProperties.getUploadSuffix();
        File filePath=new File(logoPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        String picNameOld = attach.getOriginalFilename();
        String picType = picNameOld.substring(picNameOld.lastIndexOf("."),picNameOld.length());
        String picNameNew = Uuid.getUuid() + picType;

        //最终文件名
        File realFile=new File(logoPath + File.separator + picNameNew);
        FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

        solution.setSolutionpicnamne(picNameOld);
        solution.setSolutionpic(configProperties.getUploadSuffix() + picNameNew);

        return solution;
    }

    /**
     * 根据方案和案例查询0：方案 1：案例
     * @param page
     * @param name
     * @return
     */
    @Override
    public Page<Solution> select(Integer page, String name) {
        return solutionRepository.findByNameLike(name,BasePageBuilder.create(page,configProperties.getPageSize()));
    }

    /**
     * 删除信息
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException {
            try {
            solutionRepository.delete(id);
        } catch (Exception e) {
            throw new SystemException("<script>toastr.error(\"合作伙伴信息删除失败\")</script>");
        }
    }

    /**
     * 官网根据方案展示页面
     * @return
     */
    @Override
    public List<Solution> listByName() {
        return solutionRepository.listByName();
    }

    /**
     * 官网根据产品案例展示页面
     * @return
     */
    @Override
    public List<Solution> listByName2() {
        return solutionRepository.listByName2();
    }

    /**
     * 发布
     * @param solution
     * @throws SystemException
     */
    @Override
    public void save(Solution solution,Mess mess)  throws Exception {

        //调用下面的保存简报方法
        solution=saveMess(solution,mess);

        solutionRepository.save(solution);

    }

    /**
     * 保存到简报表
     * @param solution
     * @param mess
     * @return
     * @throws IOException
     */
    private Solution saveMess(Solution solution, Mess mess) throws Exception {

        mess.setAuthortime(new Date());
        mess.setTablename(Solution.class.getSimpleName());
        mess.setTableid(solution.getId());
        mess.setAuthor(solution.getAuthor());
        mess.setTitle(solution.getTitle());
        mess.setOutline(solution.getOutline());

        messRepository.save(mess);
        return solution;
    }
    /**
     * 取消发布
     * @param id
     */
    @Override
    public void updateState(String id) throws SystemException {
        solutionRepository.updateState(id);
    }
}
