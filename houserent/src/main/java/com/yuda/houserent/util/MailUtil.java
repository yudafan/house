package com.yuda.houserent.util;

import io.github.biezhi.ome.OhMyEmail;

import javax.mail.MessagingException;
import java.util.Properties;

/*
发送邮件工具类
 */
public class MailUtil {
    //邮件服务器
    private static String host="smtp.qq.com";
    //发送邮件的账号
    private static String username="1357680645@qq.com";
    //发送邮件的密码
    private static String pwd="cghawpigquinjeic";
    //发送者姓名
    private static  String fromname="贾余名";
    /*
    配置邮件
     */
    public static void configMail(String smtpHost,String userName,String passWord){
        Properties properties= OhMyEmail.defaultConfig(false);
        properties.setProperty("mail.smtp.host",smtpHost);
        OhMyEmail.config(properties,userName, passWord);
    }
    /**发送邮件
    *to            接收者
     * title        标题
     * content        内容
     */
    public static void sendEmail(String to,String title,String content)throws MessagingException{
        configMail(host,username,pwd);
        OhMyEmail.subject(title).from(fromname).to(to).html(content).send();
    }
    public static void main(String[] args) throws MessagingException {
        sendEmail(username,"惊不惊喜","意不意外");
    }

}
