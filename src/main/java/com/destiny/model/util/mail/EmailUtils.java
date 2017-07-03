package com.destiny.model.util.mail;

import com.sun.deploy.config.Config;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;


public class EmailUtils {


    private static Logger logger = LoggerFactory.getLogger(EmailUtils.class);
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            throw new RuntimeException("读取config.properties文档异常");
        }
    }

    /**
     * @param key 输入查询的key
     * @return 返回值
     */

    public static String get(String key) {
        return properties.getProperty(key);
    }

    /**
     *
     * @param key 输入查询的key
     * @param defaultvalue  默认值
     * @return 返回值
     */
    public static String get(String key, String defaultvalue) {
        return properties.getProperty(key, defaultvalue);
    }

    /**
     * @param email   要发送的邮件地址
     * @param subject 邮件的主题
     * @param content 邮件的内容
     */
    public static void sendEmail(String email, String subject, String content) {

        HtmlEmail htmlEmail = new HtmlEmail();
        htmlEmail.setHostName(get("mail.hostname")); // 主机号
        htmlEmail.setSmtpPort(Integer.parseInt(get("mail.port", "25"))); // 端口号
        htmlEmail.setAuthentication(get("mail.username"), get("mail.password")); //授权码
        htmlEmail.setCharset(get("mail.charset")); // 字符集
        logger.debug("begin execute the try/catch");
        try {
            htmlEmail.setFrom(get("mail.fromEmail")); // 发送方
            htmlEmail.setSubject(subject); // 主题
            htmlEmail.setHtmlMsg(content); // 内容
            htmlEmail.addTo(email);  // 接收方
            htmlEmail.send();  // 发送
            logger.debug(content);
            logger.debug("the email to {} is successful", email);

        } catch (Exception e) {
            logger.debug("the email to {} is failure", email);
            throw new RuntimeException("send email failure", e);
        }

    }


    public static void main(String[] args) {

        sendEmail("xieyue86@163.com","this is for test!","this is content ");

    }

}
