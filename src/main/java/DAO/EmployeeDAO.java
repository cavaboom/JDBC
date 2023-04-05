package DAO;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    List<Employee> getEmployeeById();
    List<Employee> getEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);

}
