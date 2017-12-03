package com.test.demo1.impl;

import com.test.demo1.A;
import org.springframework.stereotype.Component;

@Component
public class B implements A {
    @Override
    public String printA() {
        return "b";
    }
}
