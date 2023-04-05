package DAO;

import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final String user = "postgres";
    private final String password = "0208";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void addEmployee(Employee employee) {
        try (final Connection connection =
                DriverManager.getConnection(url, user, password);
            PreparedStatement statement =
                connection.prepareStatement("INSERT INTO employee(first_name, last_name, gender, age, city_id)" +
                        "VALUES " + ("(?, ?, ?, ?, ?)"))) {
            System.out.println("Соединение установлено!");
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getEmployeeById() {
        List<Employee> employees = new ArrayList<>();
        int idOfEmployee = 2;
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee WHERE id = ?")) {
            statement.setInt(1, idOfEmployee);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection =
                        DriverManager.getConnection(url, user, password);
            PreparedStatement statement =
                        connection.prepareStatement("SELECT * FROM employee")) {
            ResultSet resultSet = statement.executeQuery();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) WHERE id = (?)")) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.setInt(6, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  void deleteEmployee(int id) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
