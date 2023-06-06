package test;


import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        CityDAO cityDAO = new CityDAOImpl();
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        City city = new City ("Москва");
        cityDAO.addInDataBase(city);


        Employee employee = new Employee("Sofia", "Belova", "f", 45, city);
        Employee employee2 = new Employee("Milana", "Belova", "f", 35, city);
        employeeDAO.addInDataBase(employee);
        employeeDAO.addInDataBase(employee2);
        city.setEmployees(List.of(employee,employee2));
        Employee employee3 = new Employee("Bat", "Man", "m", 33, city);
        employeeDAO.changeEmployee(1, employee3);

      }
}