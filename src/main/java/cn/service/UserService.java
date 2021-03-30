package cn.service;

import cn.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/29 16:09
 * @Description:
 * @version：1.0
 **/
public interface UserService {
    int adduser(User u);
    List<User> select(@Param("username") String username, @Param("password") String password);
    int exists(String username,String password);
}
