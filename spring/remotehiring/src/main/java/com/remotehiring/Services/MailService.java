package com.remotehiring.Services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import com.remotehiring.entities.Users;
import com.remotehiring.exceptions.CustomMailException;

@Service
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;

    public void signupMail(Users user) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Template template = emailConfig.getTemplate("email.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, user);

            mimeMessageHelper.setTo(user.getEmail());
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject("Welcome " + user.getFullname());
            mimeMessageHelper.setFrom("sirichandana.p96@gmail.com");
            emailSender.send(message);
        } catch (IOException | TemplateException | MessagingException e) {
            throw new CustomMailException("Failed to send signup email to user: " + user.getEmail(), e);
        }
    }
}
