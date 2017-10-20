package com.redoop.common.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 说明： 发送邮件工具类
 * 创建人：Itdeer
 * 创建时间：2017-09-05 上午9:21.
 */
public class EmailUtils {


    /**
     * 发送邮件
     * @param to
     * @param content
     */
    public void sendMail(JavaMailSender javaMailSender,String from,String to,String subject,String content){
        Email email = new Email(from,to,subject,content);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());

        javaMailSender.send(message);
        email.setStatus(true);
    }
}
