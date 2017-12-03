package com.test.demo3;

import com.test.demo3.annotation.ZxfResource;
import com.test.demo3.dao.User1DaoImpl;
import com.test.demo3.dao.User2DaoImpl;
import com.test.demo3.dao.UserDaoImpl;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {

    private UserDaoImpl userDao;
    private User1DaoImpl user1Dao;

    @ZxfResource
    private User2DaoImpl user2Dao;

    @ZxfResource(name = "userDao")
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    // set方法上的注解，没有配置name属性
    @ZxfResource
    public void setUser1Dao(User1DaoImpl user1Dao) {
        this.user1Dao = user1Dao;
    }

    public void show() {
        userDao.show();
        user1Dao.show();
        user2Dao.show();
        System.out.println("这里是Service方法........");
    }
}
