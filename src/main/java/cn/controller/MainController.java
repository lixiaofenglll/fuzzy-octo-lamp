package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/29 16:31
 * @Description:
 * @version：1.0
 **/
@Controller
public class MainController {
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/toindex")
    public String toindex(){
    return "index";
    }
}
