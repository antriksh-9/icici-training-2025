package com.icici.colls;

public class ConditionStartsWithR implements Condition<Employee>{

    @Override
    public boolean test(Employee e) {
       return e.name.startsWith("R");
    }
    
}
