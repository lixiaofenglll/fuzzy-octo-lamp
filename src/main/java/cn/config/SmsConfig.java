package cn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/26 11:34
 * @Description:
 **/
@Component
@ConfigurationProperties(prefix = "sms")
public class SmsConfig {
    private String serverip;
    private String port;
    private String accountsid;
    private String accounttoken;
    private String appid;
    private String templateid;

    public String getServerip() {
        return serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAccountsid() {
        return accountsid;
    }

    public void setAccountsid(String accountsid) {
        this.accountsid = accountsid;
    }

    public String getAccounttoken() {
        return accounttoken;
    }

    public void setAccounttoken(String accounttoken) {
        this.accounttoken = accounttoken;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }
}
