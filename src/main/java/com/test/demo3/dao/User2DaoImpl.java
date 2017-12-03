package com.test.demo3.dao;

import org.springframework.stereotype.Component;

@Component
public class User2DaoImpl {

    String name;

    public void show(){
        System.out.println("这里是dao2的方法......");
    }
}
