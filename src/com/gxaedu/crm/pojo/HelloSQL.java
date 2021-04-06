package com.gxaedu.crm.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/16
 * Description:
 * Version: V1.0
 */
public class HelloSQL {
    // bean规范   广域模型
    // 为每一个私有级的属性设置对应的set和get方法(全球化规范)
    private int id;
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
