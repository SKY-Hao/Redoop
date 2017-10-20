package com.redoop.common.utils;

import com.redoop.RedoopApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedoopApplication.class)
public class EmailTest {

    @Autowired
        private JavaMailSender javaMailSender;

    @Test
    public void send() throws Exception {
        Email email = new Email("787501374@qq.com","hth_swp@163.com","来自红象云腾技术系统有限公司的邮件","你好！黄天浩");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        System.out.println("邮箱测试"+email.toString());

        javaMailSender.send(message);
        email.setStatus(true);
    }
}