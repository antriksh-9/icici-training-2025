public class EmployeeTest {

    public static void main(String[] args) {

        // Employee emp = new Employee(13, "Rahul");
        // System.out.println(emp);

        // Regular Employee
        Address address = new Address(232, "Thane", "Mumbai");
        Employee re = new RegularEmployee(1, "Ravi", 34343.34, address);
        // System.out.println(re.toString());

        // RegularEmployee re2 = (RegularEmployee)re;

        Employee ce = new ContractualEmployee(2, "Priya", 3333.34);
        // System.out.println(ce);

        int i = 343;
        byte b = (byte)i;

        Employee employees[] = {re, ce};

        for(Employee e : employees){
            System.out.println(e);
            e.incrementSalary();
            e.foodCoupon();
            e.mandatoryHolidays();
            System.out.println(e);
        }

        System.out.println(b);

        System.out.println(employees.length);
    }
    
}
