package com.redoop.common.utils;


import com.redoop.RedoopApplication;
import com.redoop.common.config.ConfigProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedoopApplication.class)
public class EmailUtilsTest {

    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private JavaMailSender javaMailSender;


    @Test
    public void sendMail() throws Exception {


        EmailUtils eu = new EmailUtils();
        eu.sendMail(javaMailSender,configProperties.getMailFrom(),"893040831@qq.com",configProperties.getMailSubject(),"dddddddddddd");



    }

}