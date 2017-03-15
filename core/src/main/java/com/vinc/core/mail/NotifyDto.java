package com.vinc.core.mail;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:02 2017/3/14
 */
public class NotifyDto {
    public String host;
    @Size(
            min = 1,
            message = "收件人至少包含一位"
    )
    public String[] email;
    public String user;
    @NotBlank(
            message = "邮件标题不允许为空"
    )
    public String title;
    public String content;
    public String template = "notify.vm";

    public NotifyDto(String host, String[] email, String name, String title, String content) {
        this.host = host;
        this.email = email;
        this.user = name;
        this.title = title;
        this.content = content;
    }

    public NotifyDto() {
    }

    public String getHost() {
        return this.host;
    }

    public String[] getEmail() {
        return this.email;
    }

    public String getUser() {
        return this.user;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getTemplate() {
        return this.template;
    }
}
