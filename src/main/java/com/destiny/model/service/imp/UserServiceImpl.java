package com.destiny.model.service.imp;

import com.destiny.model.dao.UserDao;
import com.destiny.model.entity.ext.UserExt;
import com.destiny.model.service.inter.UserService;

import java.util.Date;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public UserExt addUser(UserExt user) {

        userDao.addUser(user);
        return user;
    }


    public static void main(String[] args) {

        UserExt userExt = new UserExt();

        userExt.setAddress("河南.郑州");
        userExt.setAge("16");
        userExt.setCreateTime(new Date());
        userExt.setUserName("小李");
        userExt.setNation("CHINA");
        userExt.setHobby("basketball");

        System.out.println("user is : " + userExt);

        UserServiceImpl userService = new UserServiceImpl();

        userService.addUser(userExt);





    }


}
