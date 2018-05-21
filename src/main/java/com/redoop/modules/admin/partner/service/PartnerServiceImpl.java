package com.redoop.modules.admin.partner.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.repository.MessRepository;
import com.redoop.modules.admin.partner.entity.Partner;
import com.redoop.modules.admin.partner.repository.PartnerRepository;
import com.redoop.modules.admin.solution.entity.Solution;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 说明：合作伙伴Service接口实现类
 * 包名：cn.itweet.tea.admin.partner.PartnerServiceImpl
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年9月7日17:04:25
 */
@Service
public class PartnerServiceImpl  implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private MessRepository messRepository;

    private Sort sort = new Sort(Sort.Direction.DESC,"applicationtime");


    /**
     * 合作伙伴列表
     * @return
     */
    @Override
    public Page<Partner> findAll(Integer page) {
        return partnerRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize(),sort));
    }

    /**
     * 前台展示列表
     * @return
     */
    @Override
    public Page<Partner> listByIntention(Integer page) {
        return partnerRepository.listByIntention(BasePageBuilder.create(page,configProperties.getPageSize()));
    }


    /**
     * 按照名称模糊查询
     * @param companyname
     * @return
     */
    @Override
    public Page<Partner> select(Integer page, String companyname) {

        return partnerRepository.findByCompanynameLike(companyname,BasePageBuilder.create(page,configProperties.getPageSize()));
    }


    /**
     * 按ID进行查询
     * @param id
     * @return
     */
    @Override
    public Partner findById(String id) {
        return partnerRepository.findOne(id);
    }

    /**
     * 根据公司名称进行查询公司信息
     * @param companyname
     * @return
     */
    public Partner findByComName(String companyname){
        return  partnerRepository.findByComName(companyname);
    };

    /**
     * 合作伙伴后台信息添加
     * @param partner
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    @Override
        public void save(Partner partner, MultipartFile attach, String logoPath) throws SystemException {

        if (partner.getCompanyname() == null || "".equals(partner.getCompanyname())) {
            throw new SystemException("<script>toastr.error(\"公司名称不能为空\")</script>");
        }
        if (partner.getContactsname() == null || "".equals(partner.getContactsname())) {
            throw new SystemException("<script>toastr.error(\"联系人名字不能为空\")</script>");
        }
        if (partner.getContactstel() == null || "".equals(partner.getContactstel())) {
            throw new SystemException("<script>toastr.error(\"联系人电话不能为空\")</script>");
        }
        if (partner.getContactsemail() == null || "".equals(partner.getContactsemail())) {
            throw new SystemException("<script>toastr.error(\"联系人邮箱不能为空\")</script>");
        }

        if(partner.getId() != null){
            Partner data_c = partnerRepository.findOne(partner.getId());//id
            partner.setApplicationtime(new Date());//申请时间
            partner.setAuditor(data_c.getAuditor());//审核人
            partner.setAuditortime(data_c.getAuditortime());//审核时间
            partner.setCompanypicname(data_c.getCompanypicname());//logo名称
            partner.setCompanypic(data_c.getCompanypic());//logo
            partner.setIntention("1");
            if(attach.isEmpty()){
                partner.setCompanypic(data_c.getCompanypic());
            }else{
                try {
                    partner = uploadPic(partner,attach,logoPath);
                    DeleteUtils.deletePic(logoPath + data_c.getCompanypic());
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"公司Logo上传失败\")</script>");
                }
            }

        }else{
            if(attach.isEmpty()){
                throw new SystemException("<script>toastr.error(\"公司Logo不能为空\")</script>");
            }else{
                try {
                    partner = uploadPic(partner,attach,logoPath);
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"公司Logo上传失败\")</script>");
                }
            }

            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            partner.setAuditor(user.getUsername());
            partner.setApplicationtime(new Date());//申请时间
            partner.setAuditortime(new Date());//审核时间
            partner.setIntention("1");
        }

        partnerRepository.save(partner);
    }


    /**
     * 合作伙伴前台申请添加
     * @param partner
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    @Override
    public void applySave(Partner partner, MultipartFile attach, String logoPath) throws SystemException {

        if (partner.getCompanyname() == null || "".equals(partner.getCompanyname())) {
            throw new SystemException("<script>toastr.error(\"公司名称不能为空\")</script>");
        }
        if (partner.getContactsname() == null || "".equals(partner.getContactsname())) {
            throw new SystemException("<script>toastr.error(\"联系人名字不能为空\")</script>");
        }
        if (partner.getContactstel() == null || "".equals(partner.getContactstel())) {
            throw new SystemException("<script>toastr.error(\"联系人电话不能为空\")</script>");
        }
        if (partner.getContactsemail() == null || "".equals(partner.getContactsemail())) {
            throw new SystemException("<script>toastr.error(\"联系人邮箱不能为空\")</script>");
        }
        if(partner.getId() == null){
            partner.setApplicationtime(new Date());//申请时间
            partner.setAuditortime(new Date());//审核时间
            partner.setIntention("1");
        }
        partnerRepository.save(partner);
    }

    /**
     *  合作伙伴上传logo
     * @param partner
     * @param attach
     * @param logoPath
     * @return
     * @throws IOException
     */
    private Partner uploadPic(Partner partner, MultipartFile attach,String logoPath) throws IOException {
        logoPath = logoPath + configProperties.getUploadSuffix();
        System.out.println(logoPath+"logopath");
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

        partner.setCompanypicname(picNameOld);
        partner.setCompanypic(configProperties.getUploadSuffix() + picNameNew);

        return partner;
    }

    /**
     * 删除合作伙伴信息
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException {
        try {
            partnerRepository.delete(id);
        } catch (Exception e) {
            throw new SystemException("<script>toastr.error(\"合作伙伴信息删除失败\")</script>");
        }
    }


    /**
     * 认证（未认证）认证通过是0    未认证是1
     * @param id
     * @throws SystemException
     */
    public void authenticationWRZ(String id) throws SystemException {

        partnerRepository.authenticationWRZ(id);
    }

    /**
     * 认证（未认证）认证通过是0    未认证是1
     * @param id
     * @throws SystemException
     */
    public void authenticationYRZ(String id) throws SystemException {
        partnerRepository.authenticationYRZ(id);
    }


    /**
     * 前台多选搜索(checkbox)
     * @param partnertype
     * @return
     */
    public Page<Partner> findByPartnertype(Integer page, String partnertype)throws Exception {

        // 没选择的时候默认全部
       if (StringUtils.isEmpty(partnertype)) {
            return partnerRepository.listByIntention(BasePageBuilder.create(page, configProperties.getPageSize()));
        }
        //选择>=1个的时候搜索
        Page<Partner> partnerList = null;

        String[] split = partnertype.split(",");
        List<String> partnertypes = new ArrayList<String>();

        for (String s :split ) {
            partnertypes.add(s);
        }
        partnerList = partnerRepository.findByPartnertype(partnertypes, BasePageBuilder.create(page,configProperties.getPageSize()));
        return partnerList;
    }
    /**
     * 发布
     * @param partner
     * @throws SystemException
     */
    @Override
    public void save(Partner partner ,Mess mess) throws Exception {
        partner = saveMess(partner,mess);
        partnerRepository.save(partner);
    }


    /**
     * 保存到简报表
     * @param partner
     * @param mess
     * @return
     * @throws IOException
     */
    private Partner saveMess(Partner partner, Mess mess) throws Exception {

        mess.setAuthortime(new Date());
        mess.setTablename(Partner.class.getSimpleName());
        mess.setTableid(partner.getId());
        mess.setTitle(partner.getCompanyname());
        mess.setAuthor(partner.getAuditor());
        mess.setOutline(partner.getOutline());

        messRepository.save(mess);
        return partner;
    }

    /**
     * 取消发布
     * @param id
     * @throws SystemException
     */
    @Override
    public void updateIntention(String id) throws SystemException {
        partnerRepository.updateIntention(id);
    }
}
