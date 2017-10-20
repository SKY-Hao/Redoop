package com.redoop.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Administrator on 2017/9/4.
 * 2017年9月4日21:12:49
 * 黄天浩
 * 邮件发送工具类
 *
 */
public class MailUtils {

    @Autowired
    private JavaMailSender javaMailSender;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * @param to    :给谁发邮件
     * @param code  :邮件的激活码
     */
   public static void sendMail(String to, String code) throws Exception {


        //1.创建连接对象，连接到邮件服务器
       Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //return super.getPasswordAuthentication();
                return new PasswordAuthentication("787501374@qq.com","nobqomhrlhuobbbg");
            }
        });

        //2.创建邮件对象
        Message message = new MimeMessage(session);
            //2.1设置发件人
            message.setFrom(new InternetAddress("787501374@qq.com"));
            //2.2设置收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //2.3设置邮件的主题
            message.setSubject("来自红象云腾技术系统有限公司的激活邮件");
            //2.4设置邮件的正文
            message.setContent("<h1>来自红象云腾技术系统有限公司的激活邮件,激活请点击连接:</h1>" +
                                    "<h3><a href='http://localhost:8080/front/regJH?code="+code+"'>http://localhost:8080/front/regJH?code="+code+"</a></h3>"
                                ,"text/html;charset=UTF-8");

        //3.发送一封激活邮件
        Transport.send(message);
    }

    public static void main(String[] args) throws Exception {

         sendMail("hth_swp@163.com","aaaaaa");
    }

}
