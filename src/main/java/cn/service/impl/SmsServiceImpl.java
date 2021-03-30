package cn.service.impl;

import cn.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/26 9:30
 * @Description:
 * @version：1.0
 **/
@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;
    @Override
    public int sendmsg(String mail) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(mail);
        int code = (int)(Math.random()*(9999-1000)+1000);
        mailMessage.setText("验证码："+code);
        mailMessage.setSubject("验证码");
        javaMailSender.send(mailMessage);
        return  code;
    }

    @Override
    public void sendcomplicatemsg(String msg, String mail) {
        try {
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo(mail);
            mimeMessageHelper.setSubject("abc");
            mimeMessageHelper.setText("<h1>dasfsd</h1>");
            mimeMessageHelper.addAttachment("a0364cf9gig.mp4",new File("F:\\a0364cf9gig.mp4"));
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}