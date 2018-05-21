package com.redoop.modules.admin.license.service;

import com.redoop.common.exception.ValidateException;
import com.redoop.modules.admin.license.entity.Code;
import com.redoop.modules.admin.license.entity.License;
import com.redoop.modules.admin.license.repository.LicenseRepository;
import com.google.gson.Gson;
import com.redoop.modules.admin.license.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 说明：License授权管理Service层接口实现
 * 包名：cn.itweet.tea.admin.license.service
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Service
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    /**
     * 用户申请注册许可
     * @param license
     * @param filePath
     * @return
     */
    public Message register(License license, String filePath) {

        System.out.println("GGGGGGGGGGGGGGGG:"+license.toString());

        if(license.getCompany() == null || "".equals(license.getCompany())){
            FileUtils.deleteFile(filePath);
            return new Message("toastr.error(\"申请许可的公司名称不能为空\")",null);
        }

        if(license.getProject() == null || "".equals(license.getProject())){
            FileUtils.deleteFile(filePath);
            return new Message("toastr.error(\"申请许可的项目不能为空\")",null);
        }

        if(license.getEmail() == null || "".equals(license.getEmail())){
            FileUtils.deleteFile(filePath);
            return new Message("toastr.error(\"申请人联系邮箱不能为空\")",null);
        }

        if(license.getVersion() == 0 && license.getNode() > 10){
            FileUtils.deleteFile(filePath);
            return new Message("toastr.error(\"申请试用节点数不能多于10\")",null);
        }

        //判断文件是否存在
        if(!FileUtils.fileExits(filePath)){
            return new Message("toastr.error(\"注册文件不能为空\")",null);
        }

        //读取文件
        String message = FileUtils.readFile(filePath);
        if(message == null){
            FileUtils.deleteFile(filePath);
            return new Message("toastr.error(\"注册文件不正确\")",null);
        }else{
            FileUtils.deleteFile(filePath);     //删除注册文件读取之后不为空也要删除掉文件
        }

        //解密文件
        String json;
        try {
            json = DESUtils.decrypt(message);
        }catch (Exception e){
            return new Message("toastr.error(\"注册文件不正确\")",null);
        }

        MacIp mi = new Gson().fromJson(json, MacIp.class);  //把json转成对象

        if(mi == null){
            return  new Message("toastr.error(\"注册文件解析失败\")",null);
        }
        System.out.println("1111111111:"+mi.toString());
        //已经拿到所有数据 开始准备License对象，
        License findLicense = findByCustomerInformation(mi.getMac(),mi.getIp(),license.getEmail(),license.getProject(),license.getCompany());   //根据Mac、IP、Email、Project、Company查询注册记录

        //查询到则判断试用次数

        //查询不到则添加数据
        if(findLicense == null && license.getVersion() == 0){
            license.setCreateDate(new Date());
            license.setStatus(0);
            license.setVaild(DateUtils.vaildDate(15));
            license.setVaildDays(15);
            license.setMac(mi.getMac());
            license.setIp(mi.getIp());
            license.setTrials(1);
            license.setUpdateDate(new Date());
            license.setServices(ServicesUtils.getInitService());
            license.setAllowPic(1);         //允许替换图片
            String code = getCode(license);
            license.setCode(code);

            licenseRepository.save(license);
            return new Message("toastr.success(\"申请第1次试用成功\")",code);
        }

        if(findLicense == null && license.getVersion() == 1){
            license.setCreateDate(new Date());
            license.setStatus(1);

            license.setMac(mi.getMac());
            license.setIp(mi.getIp());
            license.setUpdateDate(new Date());
            license.setTrials(0);
            license.setVaildDays(0);
            license.setVaild(DateUtils.vaildDate(0));

            licenseRepository.save(license);
            return new Message("toastr.success(\"申请正式许可提交成功\")",null);
        }



        if(license.getVersion() == 1 && findLicense.getStatus() == 0){
            findLicense.setNode(license.getNode());
            findLicense.setVaild(DateUtils.vaildDate(0));
            findLicense.setVaildDays(0);
            findLicense.setStatus(1);
            findLicense.setCode("");
            findLicense.setVersion(1);
            findLicense.setVaild("");

            findLicense.setUpdateDate(new Date());
            licenseRepository.save(findLicense);
            return new Message("toastr.success(\"申请正式许可提交成功\")",null);
        }

        if(license.getVersion() == 0 && findLicense.getStatus() ==1){
            return new Message("toastr.success(\"申请正式许可已经提交，试用提交无效\")",null);
        }

        if(license.getVersion() == 1 && findLicense.getStatus() ==1){
            return new Message("toastr.success(\"申请正式许可已经提交，无需重复提交\")",null);
        }


        if(license.getVersion() == 0 && findLicense.getTrials() >= 3){
            if(findLicense.getStatus() == 1){
                return new Message("toastr.error(\"已经提交正式申请\")",null);
            }else{
                return new Message("toastr.error(\"申请试用次数超过3次\")",null);
            }
        }else{
            int trials = findLicense.getTrials();

            if(findLicense.getStatus() == 1){
                return new Message("toastr.error(\"已经提交正式申请\")",null);
            }

            findLicense.setNode(license.getNode());
            findLicense.setVaild(DateUtils.vaildDate(15));
            findLicense.setVaildDays(15);
            findLicense.setTrials(trials + 1);
            findLicense.setUpdateDate(new Date());
            String code = getCode(findLicense);
            findLicense.setCode(code);
            licenseRepository.save(findLicense);

            return new Message("toastr.success(\"申请第" + (trials + 1) + "次试用成功\")",code);
        }

    }

    /**
     * 根据Mac、IP、Email、Project、Company查询注册记录
     * @param mac
     * @param ip
     * @param email
     * @param project
     * @param company
     * @return
     */
    private License findByCustomerInformation(String mac,String ip,String email,String project,String company){
        return licenseRepository.findByCustomerInformation(mac,ip,email,project,company);
    }

    /**
     * 根据注册信息生成注册码
     * @param license
     * @return
     */
    private String getCode(License license){
        Code code = new Code();
        code.setCompany(license.getCompany());
        code.setProject(license.getProject());
        code.setEmail(license.getEmail());
        code.setProducts(license.getProducts());
        code.setNode(license.getNode());
        code.setVersion(license.getVersion());
        code.setMacAddress(license.getMac());
        code.setIp(license.getIp());
        code.setValidPeriod(license.getVaildDays());
        code.setTrials(license.getTrials());
        code.setServices(license.getServices());

        code.setAllowPic(license.getAllowPic());

        String codeMessage = DESUtils.encryption(new Gson().toJson(code));
        return codeMessage;
    }

    /**
     * License授权列表
     * @return
     */
    public List<License> list() {
        return (List<License>) licenseRepository.findAll();
    }

    /**
     * License授权按公司查询
     * @param companyName
     * @return
     */
    public List<License> getByCompany(String companyName) {
        return licenseRepository.getByCompany(companyName);
    }

    /**
     * License授权删除
     * @param id
     */
    public void delete(Integer id) {
        licenseRepository.delete(id);
    }

    /**
     * License授权ID查询
     * @param id
     * @return
     */
    public License getById(Integer id) {
        return licenseRepository.findOne(id);
    }


    /**
     * License授权修改
     * @param license
     * @throws ValidateException
     */
    @Override
    public void edit(License license) throws ValidateException {
        License form = licenseRepository.findOne(license.getId());

        if(license.getCompany() == null || "".equals(license.getCompany())){
            throw new ValidateException("公司名称不能为空");
        }else{
            form.setCompany(license.getCompany());
        }
        if(license.getProject() == null || "".equals(license.getProject())){
            throw new ValidateException("项目名称不能为空");
        }else{
            form.setProject(license.getProject());
        }
        if(license.getEmail() == null || "".equals(license.getEmail())){
            throw new ValidateException("邮箱不能为空");
        }else {
            form.setEmail(license.getEmail());
        }

        form.setProducts(license.getProducts());
        form.setNode(license.getNode());
        form.setVersion(license.getVersion());
        form.setUpdateDate(new Date());
        licenseRepository.save(form);
    }

    /**
     * 授权
     * @param license
     * @throws ValidateException
     */
    @Override
    public void authorize(License license) throws ValidateException {
        System.out.println(license);
        License form = licenseRepository.findOne(license.getId());
        if(license.getVaildDays() == 0 || "".equals(license.getVaildDays())){
            license.setVaildDays(30);
        }

        form.setVaildDays(license.getVaildDays());
        form.setVaild(DateUtils.vaildDate(license.getVaildDays()));
        form.setAllowPic(license.getAllowPic());
        form.setUpdateDate(new Date());
        form.setServices(ServicesUtils.getInitService());
        form.setCode(getCode(form));
        form.setStatus(2);

        licenseRepository.save(form);

    }


}
