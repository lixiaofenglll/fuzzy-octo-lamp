package cn.service;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/26 9:31
 * @Description:
 * @version：1.0
 **/
public interface SmsService {
     int sendmsg(String mail);
     void sendcomplicatemsg(String msg, String mail);
}
