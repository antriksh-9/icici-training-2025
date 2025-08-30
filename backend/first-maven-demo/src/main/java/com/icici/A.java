package com.icici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    @Autowired
    B b;
    
    
    public A(B b) {
        this.b = b;
    }


    public void execute(){
        b.execute();
        System.out.println("Execute in A");
    }
}
