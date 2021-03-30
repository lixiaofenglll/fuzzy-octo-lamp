package cn.service.impl;

import cn.mapper.UserMapper;
import cn.pojo.User;
import cn.service.UserService;
import cn.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/29 16:10
 * @Description:
 * @version：1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int adduser(User u) {
        String md5 = MD5.getMd5(u.getPassword(), 32);
        u.setPassword(md5);
        return userMapper.adduser(u);
    }

    @Override
    public List<User> select(String username, String password) {
        String md5password = MD5.getMd5(password, 32);
        return userMapper.select(username,md5password);
    }

    @Override
    public int exists(String username, String password) {
        String md5 = MD5.getMd5(password, 32);
        return userMapper.exists(username,md5);
    }
}