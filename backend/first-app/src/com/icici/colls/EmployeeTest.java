package com.icici.colls;

import java.util.ArrayList;
import java.util.List;

interface Condition<T> {
    boolean test(T e);
}

public class EmployeeTest {

    public static void printEmployees(List<Employee> employees, Condition<Employee> condition) {
        for (Employee e : employees) {
            // if (e.name.startsWith("R")) {
            if (condition.test(e))
                System.out.println(e);
        }
    }

    
    public static void main(String[] args) {
        // 1. List of employee and put 5 objects
        Employee e1 = new Employee(2, "Ravi", 34343);
        Employee e2 = new Employee(21, "Raj", 24343);
        Employee e3 = new Employee(22, "Priya", 54343);
        Employee e4 = new Employee(12, "Amit", 44343);
        Employee e5 = new Employee(29, "Sumit", 74343);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        // System.out.println(employees);
        System.out.println("Employee names starting with R --- ----");
        // 2. Print all employees with name starting with 'R'
        // for (Employee e : employees) {
        // if (e.name.startsWith("R")) {
        // System.out.println(e);
        // }
        // }
        printEmployees(employees, new ConditionStartsWithR());

        System.out.println("Employee salaries > 25000  --- ----");
        // 3. Print all employees with salary>25000

        Condition<Employee> salaryGt25k = (e) -> e.salary>25000;
        printEmployees(employees, salaryGt25k);
        // for (Employee e : employees) {
        //     if (e.salary > 25000) {
        //         System.out.println(e);
        //     }
        // }

        System.out.println("Print all employees---- ");
        // 3. Print all employees with salary>25000
        printEmployees(employees, (e)->true);
        // for (Employee e : employees) {
        //     if (true) {
        //         System.out.println(e);
        //     }
        // }

        employees.stream()
        .distinct()
        .limit(2)
        .filter((e)->e.name.startsWith("R"))
        .filter((e)->e.salary>25000)
        .forEach((e)-> System.out.println(e));

        List<Double> sortedEmployees =  employees.stream()
        .map((e) -> e.salary)
        .sorted()
        .toList();

        System.out.println(sortedEmployees.get(sortedEmployees.size() -1));
    }

   

}
