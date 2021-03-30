package cn.controller;


import cn.config.RedisConfig;
import cn.dto.ResultDto;
import cn.pojo.User;
import cn.service.SmsService;
import cn.service.SmsphoneService;
import cn.service.UserService;
import cn.utils.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/29 15:21
 * @Description:
 * @version：1.0
 **/
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResultDto login(@RequestParam String userName, @RequestParam String password, HttpServletRequest req){
        List<User> select = userService.select(userName, password);
        if(select==null){
        return  ResultUtil.returnFail(SysCode.SYS_USER_PASS_ERROR.getCode(),SysCode.SYS_USER_PASS_ERROR.getDescription());
        }
         req.getSession().setAttribute("user",select);
        return ResultUtil.returnSuccess();
    }

}