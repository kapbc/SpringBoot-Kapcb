package com.kapcb.ccc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootKapcbMailTaskApplicationTests {

    @Autowired(required = false)
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void testMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 主题
        message.setSubject("通知");
        // 内容
        message.setText("我是Kapcb,今晚上山打老虎!");
        // 目的地
        message.setTo("eircccallroot@163.com");
        // 发送者 格式必须为邮箱格式，否则会报错
        message.setFrom("2530628867@qq.com");
        javaMailSender.send(message);
    }


    @Test
    public void testDemo() throws MessagingException {
        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        /**
         *      消息，是否需要上传附件
         *     public MimeMessageHelper(MimeMessage mimeMessage, boolean multipart) throws MessagingException {
         *         this(mimeMessage, multipart, (String)null);
         *     }
         */
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        //邮件设置
        mimeMessageHelper.setSubject("今晚通知");
        // html设置
        mimeMessageHelper.setText("<b style='color:red'>今晚上山打老虎</b>", true);
        // 上传文件
        mimeMessageHelper.addAttachment("pppp.jpg", new File("D:\\pppp.jpg"));

        mimeMessageHelper.setFrom("2530628867@qq.com");
        mimeMessageHelper.setTo("eircccallroot@163.com");

        javaMailSender.send(mimeMessage);
    }
}
