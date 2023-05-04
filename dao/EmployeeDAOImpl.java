package dao;

import connection.DataForConnection;
import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addInDataBase (Employee employee) {

        try (final Connection connection = DataForConnection.getConnection()) {
            String sql = "INSERT INTO employee (first_name, last_name, gender, age, city_id) " +
                    "VALUES ((?), (?), (?), (?), (?))";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_id());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        try (final Connection connection = DataForConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE id=(?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employee.setId(resultSet.getInt(1));
                employee.setFirst_name(resultSet.getString(2));
                employee.setLast_name(resultSet.getString(3));
                employee.setGender(resultSet.getString(4));
                employee.setAge(resultSet.getInt(5));
                employee.setCity(new City(resultSet.getInt("city_id")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAllEmployee() {
        Collection<Employee> employees = new ArrayList<>();

        try (final Connection connection = DataForConnection.getConnection()) {
            String sql = "SELECT * FROM employee INNER JOIN city " +
                    "ON employee.city_id = city.city_id";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int age = resultSet.getInt(5);
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String gender = resultSet.getString(4);
                City city= new City(resultSet.getInt("city_id"), resultSet.getString("city_name"));
                employees.add(new Employee(id, name, lastName, gender, age, city));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    @Override
    public void changeEmployee(int id, Employee employee) {
        try (final Connection connection = DataForConnection.getConnection()) {
            String sql = "UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) " +
                    "WHERE id = (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_id());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection = DataForConnection.getConnection()) {
            String sql = "DELETE FROM employee WHERE id = (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}