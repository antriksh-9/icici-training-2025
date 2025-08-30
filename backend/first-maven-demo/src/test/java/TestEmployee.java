import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.icici.Employee;

public class TestEmployee {
    
    @Test
    public void testSomeFunc(){
        assertTrue(true);
    }

    @Test
    public void testEmployeeIncrementSalary(){

        // preparation
        Employee employee = new Employee(2, "Priya", 23322.23);

        double expectedSalary = employee.salary + 5000;

        // call functionality
        employee.incrementSalary(5000);

        // verification
        assertEquals(expectedSalary , employee.salary);
    }
}
