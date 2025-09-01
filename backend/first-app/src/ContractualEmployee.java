import java.util.Arrays;

public class ContractualEmployee extends Employee{

    double payPerDay;

    public ContractualEmployee(int id, String name, double payPerDay) {
        super(id, name);
        this.payPerDay = payPerDay;
    }

    @Override
    public String toString() {
        return "ContractualEmployee [payPerDay=" + payPerDay + ", id=" + id + ", name=" + name + ", hobbies="
                + Arrays.toString(hobbies) + "]";
    }

    public void incrementSalary(){
        this.payPerDay += 500;
    }

    @Override
    public void mandatoryHolidays() {
       System.out.println("15 days mandatory leaves!");
    }

    
    
}
