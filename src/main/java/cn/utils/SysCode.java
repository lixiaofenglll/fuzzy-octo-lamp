package cn.utils;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/26 11:57
 * @Description:
 **/
public enum SysCode {
    SYS_EXCEPTION(10000, "系统异常"),
    SYS_USER_NOT_EXISTS(10002, "用户不存在"),
    SYS_USER_PASS_ERROR(10003, "用户密码错误"),
    SYS_GET_VALIDATE_CODE_ERROR(10004, "邮箱或手机号错误"),
    SYS_SEND_SMS_ERROR(10005,"发送短信失败"),
    SYS_REGISTER_VALIDATECODE_ERROR(10005,"验证码错误"),
    ;
    private int code; //状态码
    private String description; //描述

    SysCode(int code, String description){
        this.code = code;
        this.description=description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
