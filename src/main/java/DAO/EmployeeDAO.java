package DAO;

import model.Employee;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EmployeeDAO {
    Integer addEmployee(Employee employee);
    Employee getById(int id);
//    List<Employee> getEmployeeById();
    List<Employee> getEmployees();
    void updateEmployee(Employee employee, int id);
    void deleteEmployee(Employee employee);

}
