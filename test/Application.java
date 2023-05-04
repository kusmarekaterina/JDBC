package test;

import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

public class Application {

    public static void main(String[] args) {

//        try (final Connection connection = DataForConnection.getConnection()) {
//            String sql = "SELECT * FROM employee WHERE id = (?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, 2);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()){
//                String name = resultSet.getString(2);
//                String lastName = resultSet.getString(3);
//                String gender = resultSet.getString(4);
//                int city_id = resultSet.getInt(6);
//                int age = resultSet.getInt(5);
//                int id = resultSet.getInt(1);
//                System.out.println(id + " " + name + " " + lastName + " " + gender + " " + age + " " + city_id);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        Employee employee = new Employee("Sofia", "Belova", "f", 45, new City(832));
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.addInDataBase(employee);
        System.out.println(employeeDAO.getById(6));
        System.out.println(employeeDAO.findAllEmployee());
        Employee employee2 = new Employee("Milana", "Belova", "f", 35, new City(832));
        employeeDAO.changeEmployee(6, employee2);
        System.out.println(employeeDAO.getById(6));
        employeeDAO.deleteEmployee(6);
        System.out.println(employeeDAO.findAllEmployee());

    }
}