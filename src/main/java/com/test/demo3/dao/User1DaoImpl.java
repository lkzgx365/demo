package com.test.demo3.dao;

import org.springframework.stereotype.Component;

@Component
public class User1DaoImpl {

    String name;

    public void show(){
        System.out.println("这里是dao1的方法......");
    }
}
