package cn.mapper;

import cn.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/29 10:35
 * @Description:
 * @version：1.0
 **/
@Mapper
@Repository
public interface UserMapper {
    int adduser(User u);
    List<User> select(@Param("username") String username,@Param("password") String password);
    int exists(@Param("username") String username,@Param("password") String password);
}
