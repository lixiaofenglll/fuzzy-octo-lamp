package cn.pojo;

import java.util.Date;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/29 10:22
 * @Description:
 * @version：1.0
 **/
public class User {
   private int id;
   private String userName;
   private String password;
   private String realName;

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", userName='" + userName + '\'' +
              ", password='" + password + '\'' +
              ", realName='" + realName + '\'' +
              '}';
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getRealName() {
      return realName;
   }

   public void setRealName(String realName) {
      this.realName = realName;
   }

   public User() {
   }

   public User(int id, String userName, String password, String realName) {
      this.id = id;
      this.userName = userName;
      this.password = password;
      this.realName = realName;
   }
}