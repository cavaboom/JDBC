import DAO.CityDAO;
import DAO.CityDAOImpl;
import model.City;
import model.Employee;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        allEmployees(employeeDAO);
    }

    public static void allEmployees(EmployeeDAO employeeDAO) {
        System.out.println("Все работники");
        List<Employee> employees = employeeDAO.getEmployees();
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    public static void allCities(CityDAO cityDAO) {
        System.out.println("Все города");
        List<City> cities = cityDAO.getAllCity();
        for (City c : cities) {
            System.out.println(c.toString());
        }
    }

    public static void addCity(City city, CityDAO cityDAO) {
        cityDAO.add(city);
    }

    public static void getCityById(CityDAO cityDAO, int id) {
        cityDAO.getById(id);
    }
    public static void updateCity(CityDAO cityDAO) {
        cityDAO.updateCity((City) cityDAO);
    }
    public static void deleteCity(CityDAO cityDAO) {
        cityDAO.deleteCity((City) cityDAO);
    }
}
