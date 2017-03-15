package com.vinc.core.mail;

import com.vinc.core.util.CommonUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:01 2017/3/14
 */

public class Mailer {
    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;
    private static final String MAIL_FROM = "851488360@qq.com";

    public Mailer() {
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    private void send(String[] to, String subject, String content) {
        if (ArrayUtils.isEmpty(to)) {
//            throw new ValidateException("收件人不允许为空！");
        } else if (StringUtils.isBlank(subject)) {
//            throw new ValidateException("邮件主题不允许为空！");
        } else {
            this.mailSender.send((mimeMessage) -> {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setSubject("发送邮件－" + subject);
                message.setFrom("851488360@qq.com");
                message.setText(content, true);
            });
        }
    }

    public void sendNotify(NotifyDto notifyDto) {
        String text = StringUtils.trimToEmpty(notifyDto.content);
        if (StringUtils.isNotBlank(notifyDto.template)) {
            text = VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, notifyDto.template, "UTF-8", CommonUtils.bean2Map(notifyDto));
        }

        this.send(notifyDto.email, notifyDto.title, text);
    }
}
