package com.test.demo3.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl {

    String name;

    public void show(){
        System.out.println("这里是dao的方法......");
    }
}
