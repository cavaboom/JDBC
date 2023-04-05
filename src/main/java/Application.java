import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "0208";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection =
                    DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                    connection.prepareStatement("SELECT id, first_name, last_name, gender, age, city_name " +
                            "FROM employee " +
                            "LEFT JOIN city ON employee.city_id = city.city_id " +
                            "ORDER BY id")) {
            System.out.println("Соединение установлено");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String cityName = resultSet.getString("city_name");

                System.out.print(" id: " + idOfEmployee);
                System.out.print(" Имя: " + firstName);
                System.out.print(" Фамилия: " + lastName);
                System.out.print(" Пол: " + gender);
                System.out.print(" Возраст: " + age);
                System.out.print(" Город: " + cityName);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.getEmployees();
        System.out.println(employees);

    }
}
