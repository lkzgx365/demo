package com.test.demo2;

import java.lang.annotation.*;

@Documented//表示使用该注解的元素应被javadoc或类似工具文档化，
@Target(ElementType.METHOD)//表示支持注解的程序元素的种类，一些可能的值有TYPE, METHOD, CONSTRUCTOR, FIELD等等。如果Target元注解不存在，那么该注解就可以使用在任何程序元素之上。
@Inherited //表示一个注解类型会被自动继承，如果用户在类声明的时候查询注解类型，同时类声明中也没有这个类型的注解，那么注解类型会自动查询该类的父类，这个过程将会不停地重复，直到该类型的注解被找到为止，或是到达类结构的顶层（Object）。
@Retention(RetentionPolicy.RUNTIME)//表示注解类型保留时间的长短，它接收RetentionPolicy参数，可能的值有SOURCE, CLASS, 以及RUNTIME。
public @interface MethodInfo {

    String author() default "Pankaj";
    String date();
    int revision() default 1;
    String comments();
}
