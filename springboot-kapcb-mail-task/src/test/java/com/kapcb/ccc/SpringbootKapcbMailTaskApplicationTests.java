package com.kapcb.ccc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootKapcbMailTaskApplicationTests {

    @Autowired(required = false)
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void testMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知");
        message.setText("我是Kapcb,今晚上山打老虎!");
        message.setTo("eircccallroot@163.com");
        message.setFrom("Kapcb");
        javaMailSender.send(message);
    }

}
