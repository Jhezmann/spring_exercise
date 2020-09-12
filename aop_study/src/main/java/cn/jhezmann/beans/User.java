package cn.jhezmann.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer id;
    private String realname;
    @Value("${mysql.username}")
    private String username;

    public User(){
        System.out.println("User类加载。");
    }

    public User(Integer id, String realname, String username) {
        this.id = id;
        this.realname = realname;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    //--------------------------------------------set方法

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //---------------------------------------------get方法

    public Integer getId() {
        return id;
    }

    public String getRealname() {
        return realname;
    }

    public String getUsername() {
        return username;
    }
}
