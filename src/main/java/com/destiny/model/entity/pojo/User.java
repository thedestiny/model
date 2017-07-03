package com.destiny.model.entity.pojo;

import java.util.Date;

public class User {

    private Integer id;
    private String userName;
    private String address;
    private String hobby;
    private String nation;
    private Date createTime;
    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hoby) {
        this.hobby = hoby;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", hobby='" + hobby + '\'' +
                ", nation='" + nation + '\'' +
                ", createTime=" + createTime +
                ", age='" + age + '\'' +
                '}';
    }
}
