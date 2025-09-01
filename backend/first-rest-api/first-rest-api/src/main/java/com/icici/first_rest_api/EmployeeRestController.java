package com.icici.first_rest_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class EmployeeRestController {

    List<Employee> employees = new ArrayList<>();
    {
         Employee e1 = new Employee(2, "Ravi", 34343);
        Employee e2 = new Employee(21, "Raj", 24343);
        Employee e3 = new Employee(22, "Priya", 54343);
        Employee e4 = new Employee(12, "Amit", 44343);
        Employee e5 = new Employee(29, "Sumit", 74343);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
    }

    @GetMapping("/employees")   
    public List<Employee> fetchAllEmployees(){
        return this.employees;
    }

    @GetMapping("/employees/{id}")   
    public List<Employee> fetchEmployee(@PathVariable("id") int id){
        List<Employee> emps =  employees.stream()
        .filter((e)-> e.id == id)
        .toList();

        if(emps.size() > 0 ){
            return emps;
        }
        else{
            throw new EmployeeNotFoundException("Employee not found with Id " + id);
        }
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        // if()
        // return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        List<Employee> filteredList = employees.stream()
        .filter((e)-> e.id != id)
        .toList();

        this.employees = filteredList;
    }
    
    @PatchMapping("/employees/{id}")
    public void updateEmployeeSalary(@PathVariable("id") int id, @RequestBody Employee employee){

        for(Employee e : employees){
            if(e.id == id){
                e.setSalary(employee.salary);
            }
        }
    }

}
