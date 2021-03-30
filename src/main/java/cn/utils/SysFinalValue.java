package cn.utils;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/29 9:33
 * @Description:
 **/
public class SysFinalValue {
    public static final int validate_code_expire= 3; //短信验证码2分钟
    public static final int validate_code_redis_expire =180;//验证码有效期120秒
    public static final int login_user_expire=2*60*60;//用户登录有效时间2小时
    public static final String validateCode_pre="validate_";

}
