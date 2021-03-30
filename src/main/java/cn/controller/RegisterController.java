package cn.controller;

import cn.dto.ResultDto;
import cn.pojo.User;
import cn.service.SmsService;
import cn.service.SmsphoneService;
import cn.service.UserService;
import cn.utils.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/29 16:23
 * @Description:
 * @version：1.0
 **/
@Controller
public class RegisterController {
    @Autowired
    SmsphoneService smsphoneService;
    @Autowired
    SmsService smsService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserService userService;

    @PostMapping("/getCode")
    @ResponseBody
    public ResultDto getCode(@RequestParam String username){

        if(!DataValidateUtil.checkMail(username)){
            int code = smsService.sendmsg(username);
            redisUtils.set(username,code, SysFinalValue.validate_code_expire);
            return ResultUtil.returnSuccess();
        }else if(!DataValidateUtil.checkPhone(username)){
            int code = smsphoneService.Smsmsg(username);
            redisUtils.set(username,code, SysFinalValue.validate_code_expire);
            return ResultUtil.returnSuccess();
        }
        return ResultUtil.returnFail(SysCode.SYS_GET_VALIDATE_CODE_ERROR.getCode(),SysCode.SYS_GET_VALIDATE_CODE_ERROR.getDescription());
    }
    @PostMapping("/verifycode")
    @ResponseBody
    public ResultDto verifycode(@RequestParam String code,@RequestParam String username){
        if(!code.equals(redisUtils.get(username))){
            return  ResultUtil.returnFail(SysCode.SYS_REGISTER_VALIDATECODE_ERROR.getCode(),SysCode.SYS_REGISTER_VALIDATECODE_ERROR.getDescription());
        }
        return  ResultUtil.returnSuccess();
    }
    @PostMapping("/register")
    @ResponseBody
    public String register(User u){
       if(!u.getUserName().equals("")&&!u.getPassword().equals("")){
            return JSON.toJSONString("0");
       }
        int exists = userService.exists(u.getUserName(), u.getPassword());
        return JSON.toJSONString(exists);


    }
}