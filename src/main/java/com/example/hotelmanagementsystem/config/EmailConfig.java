package com.example.hotelmanagementsystem.config;

import com.example.hotelmanagementsystem.entity.EmailCredentials;
import com.example.hotelmanagementsystem.repo.EmailCredRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Autowired
    private EmailCredRepo emailCredRepo;

    @Bean
    public JavaMailSender getJavaMailSender() throws Exception {
        try {
            EmailCredentials emailCredentials = emailCredRepo.findOneByActive();
            if (emailCredentials !=null){
                JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

                Properties props = new Properties();
                props.put("mail.transport.protocol", emailCredentials.getProtocol());
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.debug", "true");
                mailSender.setJavaMailProperties(props);

                mailSender.setHost(emailCredentials.getHost());
                mailSender.setPort(Integer.valueOf(emailCredentials.getPort()));
                mailSender.setUsername(emailCredentials.getEmail());
                mailSender.setPassword(emailCredentials.getPassword());
                return mailSender;
            }else {
                return new JavaMailSenderImpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
