package com.icici;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        A a = context.getBean(A.class);

        // B b = new B();
        // A a = new A(b);
        a.execute();
        // context.
    }
}