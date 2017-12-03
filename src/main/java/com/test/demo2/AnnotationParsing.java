package com.test.demo2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsing {
    public static void main(String[] args) {
        try {
            for(Method method : AnnotationParsing.class.getClassLoader().loadClass("com.test.demo2.AnnotationExample").getMethods()){
                if(method.isAnnotationPresent(com.test.demo2.MethodInfo.class)){
                    for(Annotation annotation : method.getDeclaredAnnotations()){
                        System.out.println("Annotation in method" + method + " : " + annotation);
                    }
                    MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                    if(methodInfo.revision()==1){
                        System.out.println("method with revision on 1 = " + method);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
