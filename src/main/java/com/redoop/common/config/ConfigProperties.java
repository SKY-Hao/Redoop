package com.redoop.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 获取配置
 */
@Component
public class ConfigProperties {

    @Value("${application.upload.suffix}")
    private String uploadSuffix;
    public String getUploadSuffix() {
        return uploadSuffix;
    }

    @Value("${mail.subject}")
    private String mailSubject;
    public String getMailSubject() {
        return mailSubject;
    }

    @Value("${mail.from}")
    private String mailFrom;
    public String getMailFrom() {
        return mailFrom;
    }

    /**
     * 获取系统默认分页 每页大小
     */
    @Value("${system.page.size}")
    private int pageSize;
    public int getPageSize() {
        return pageSize;
    }

}
