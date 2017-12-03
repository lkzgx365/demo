package com.test.demo2;

public class AnnotationExample {
    public static void main(String[] args) {

    }

    @Override
    @MethodInfo(author = "zgx",date="now",revision=1,comments = "1")
    public String toString(){
        return "Overriden toString method";
    }
}
