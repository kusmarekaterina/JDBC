package test;


import dao.EmployeeDAOImpl;
import model.Employee;

public class Application {

    public static void main(String[] args) {
        Employee employee = new Employee("Sofia", "Belova", "f", 45, 832);
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.addInDataBase(employee);
        System.out.println(employeeDAO.getById(1));
        System.out.println(employeeDAO.findAllEmployee());
        Employee employee2 = new Employee("Milana", "Belova", "f", 35, 832);
        employeeDAO.changeEmployee(1, employee2);
        Employee employee3 = new Employee("Bat", "Man", "m", 33, 1);
        employeeDAO.addInDataBase(employee3);
        System.out.println(employeeDAO.getById(3));
        employeeDAO.deleteEmployee(employee3);
      }
}