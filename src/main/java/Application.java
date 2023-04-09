import model.Employee;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.getEmployees();
        System.out.println(employees);
    }
}
