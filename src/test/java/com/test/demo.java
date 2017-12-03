package com.test;

import com.test.demo1.impl.B;
import com.test.demo1.util.SpringFactoryUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.test"})
public class demo {

    @Test
    public void test1(){
        System.out.println(SpringFactoryUtil.getBean(B.class).printA());
    }
}
