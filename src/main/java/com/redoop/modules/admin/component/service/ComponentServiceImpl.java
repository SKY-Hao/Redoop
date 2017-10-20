package com.redoop.modules.admin.component.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.component.entity.Component;
import com.redoop.modules.admin.component.repository.ComponentRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 说明：服务Service接口实现类
 * 包名：cn.itweet.modules.admin.component.service
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/13.
 */
@Service
public class ComponentServiceImpl implements ComponentService{

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private ConfigProperties configProperties;


    /**
     * 查询服务软件名称列表
     * @return
     */
    @Override
    public List<String> findComponentNameList() {
        return componentRepository.findComponentNameList();
    }

    @Override
    public Page<Component> findAll(Integer page) {
        return  componentRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize()));
    }

    /**
     * 服务软件添加
     * @param component
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    @Override
    public void save(Component component, MultipartFile attach, String logoPath) throws SystemException {

        if (component.getName() == null || "".equals(component.getName())) {
            throw new SystemException("<script>toastr.error(\"服务软件名称不能为空\")</script>");
        }

        if (component.getSubjection() == null || "".equals(component.getSubjection())) {
            throw new SystemException("<script>toastr.error(\"服务软件所属不能为空\")</script>");
        }

        if (component.getMemorysize() == null || "".equals(component.getMemorysize())) {
            throw new SystemException("<script>toastr.error(\"服务软件存储大小不能为空\")</script>");
        }

        if (component.getDownurl() == null || "".equals(component.getDownurl())) {
            throw new SystemException("<script>toastr.error(\"服务软件下载地址不能为空\")</script>");
        }

        if (attach.isEmpty() && component.getId() == null) {
            throw new SystemException("<script>toastr.error(\"服务软件Logo不能为空\")</script>");
        }

        if(component.getId() != null){
            Component data_c = componentRepository.findOne(component.getId());
            component.setAdddate(data_c.getAdddate());
            component.setEditdate(new Date());
            component.setAdditive(data_c.getAdditive());
            component.setDownloads(data_c.getDownloads());
            component.setPicname(data_c.getPicname());
            component.setPicurl(data_c.getPicurl());

            if(attach.isEmpty()){
                component.setPicurl(data_c.getPicurl());
            }else{
                try {
                    component = uploadPic(component,attach,logoPath);
                    DeleteUtils.deletePic(logoPath + data_c.getPicurl());
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"服务软件Logo上传失败\")</script>");
                }
            }

        }else{
            if(attach.isEmpty()){
                throw new SystemException("<script>toastr.error(\"服务软件Logo不能为空\")</script>");
            }else{
                try {
                    component = uploadPic(component,attach,logoPath);
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"服务软件Logo上传失败\")</script>");
                }
            }
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            component.setAdditive(user.getUsername());
            component.setAdddate(new Date());
            component.setEditdate(new Date());
        }

        componentRepository.save(component);
    }

    /**
     * 服务组件信息按照类型查询列表
     * @param type
     * @return
     */
    public Page<Component> listByType(String type,Integer page) {
        return componentRepository.listByType(type,BasePageBuilder.create(page,configProperties.getPageSize()));
    }

    /**
     * 服务软件按ID查询
     * @param id
     * @return
     */
    @Override
    public Component findById(String id) {
        return componentRepository.findOne(id);
    }

    /**
     * 按ID删除
     * @param id
     * @throws SystemException
     */
    @Override
    public void delete(String id) throws SystemException {
        try {
            componentRepository.delete(id);
        } catch (Exception e) {
            throw new SystemException("<script>toastr.error(\"服务软件删除失败\")</script>");
        }
    }

    /**
     * 按照名称模糊查询
     * @param name
     * @return
     */
    @Override
    public Page<Component> selectByName(Integer page,String name) {

        System.out.println(name+"---------------");
        return componentRepository.findByNameLike(name,BasePageBuilder.create(page,configProperties.getPageSize()));
    }

    /**
     * 服务软件LOGO上传
     * @param component
     * @param attach
     * @return
     * @throws IOException
     */
    private Component uploadPic(Component component, MultipartFile attach,String logoPath) throws IOException {
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

        component.setPicname(picNameOld);
        component.setPicurl(configProperties.getUploadSuffix() + picNameNew);

        return component;
    }

}
