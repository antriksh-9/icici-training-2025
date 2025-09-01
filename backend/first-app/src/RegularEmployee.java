import java.util.Arrays;

public class RegularEmployee extends Employee{
    
    double salary;

    public RegularEmployee(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }
    public RegularEmployee(int id, String name, double salary, Address address) {
        super(id, name);
        this.salary = salary;
        this.address = address;
    }

      public void incrementSalary(){
        this.salary *= 1.1;
    }
    @Override
    public String toString() {
        return "RegularEmployee [id=" + id + ", salary=" + salary + ", name=" + name + ", hobbies="
                + Arrays.toString(hobbies) + ", address=" + address + "]";
    }

   
 @Override
    public void mandatoryHolidays() {
       System.out.println("25 days mandatory leaves!");
    }
    

    
}
