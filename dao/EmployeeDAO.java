package dao;

import model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeDAO {

    void addInDataBase (Employee employee);

    Employee getById (int id);

    List<Employee> findAllEmployee ();

    void changeEmployee (int id, Employee employee);

    void deleteEmployee (Employee employee);
}