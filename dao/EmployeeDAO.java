package dao;

import model.Employee;

import java.util.Collection;

public interface EmployeeDAO {

    void addInDataBase (Employee employee);

    Employee getById (int id);

    Collection<Employee> findAllEmployee ();

    void changeEmployee (int id, Employee employee);

    void deleteEmployee (int id);
}