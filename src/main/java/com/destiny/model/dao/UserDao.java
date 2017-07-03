package com.destiny.model.dao;

import com.destiny.model.entity.pojo.User;
import com.destiny.model.util.db.DbHelper;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class UserDao {

    public List<User> queryByUserName(String username) {

        String sql = "SELECT * from user where userName = ? ";

        return DbHelper.query(sql, new BeanListHandler<>(User.class), username);

    }


    public int addUser(User user){

        String sql = "INSERT INTO `model`.`user` (`userName`, `address`, `hobby`, `nation`, `createTime`, `age`) VALUES (?, ?, ?, ?, ?, ?);";

        return DbHelper.update(sql,user.getUserName(),user.getAddress(),user.getHobby(),user.getNation(),user.getCreateTime(),user.getAge());

    }






}
