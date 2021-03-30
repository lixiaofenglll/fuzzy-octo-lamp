package cn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/29 4:12
 * @Description:
 **/
public class DataValidateUtil {
    /**
     * 验证是否为手机号
     * @param phoneNumber
     * @return
     */
    public static boolean checkPhone(String phoneNumber) {
        String regex = "^1\\d{10}$";
        if(phoneNumber==null||phoneNumber.length()<=0){
            return false;
        }
        return Pattern.matches(regex, phoneNumber);
    }

    /**
     * 判断邮箱格式是否正确
     * @param str
     * @return
     */
    public static boolean checkMail(String str) {
        //规则：只允许英文字母、数字、下划线、英文句号、以及中划线、@符号组成
        String regEx1 = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern p = Pattern.compile(regEx1);
        if(p.matcher(str).matches())
            return  true;
        return false;
    }
}
