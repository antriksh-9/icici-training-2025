package com.icici;

import java.util.Arrays;

public class Employee extends Object{

    int id;
    String name;
    public double salary;
    String[] hobbies;

    public Employee(){

    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void incrementSalary(int amount){
        this.salary += amount;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", hobbies=" + Arrays.toString(hobbies)
                + "]";
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(12, "Ravi",34343.343);
        String hobbies[] = {"Travel", "Blog"};
        e1.setHobbies(hobbies);
        System.out.println(e1.toString());
    }
    
}
