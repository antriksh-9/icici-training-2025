import java.util.Arrays;

public abstract class Employee extends Object implements Perks{

    int id;
    String name;
  
    String[] hobbies;
    Address address;

    public Employee(){

    }

    @Override
    public void foodCoupon(){
        System.out.println("Issue food coupons...");
    }

    public abstract void incrementSalary();

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Employee(int id, String name, Address address) {
        this(id, name);
        this.address = address;
    }



    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + " + hobbies=" + Arrays.toString(hobbies)
                + "]";
    }

    public static void main(String[] args) {
        // Employee e1 = new Employee(12, "Ravi");
        // String hobbies[] = {"Travel", "Blog"};
        // e1.setHobbies(hobbies);
        // System.out.println(e1.toString());
    }
    
}
