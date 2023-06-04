package dao;

import connection.DataForConnection;
import connection.HibernateUtil;

import model.Employee;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static connection.HibernateUtil.*;


public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addInDataBase (Employee employee) {
        try {
            EntityManager entityManager = createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Employee getById(int id) {

        try {
            EntityManager entityManager = createEntityManager();
            return entityManager.find(Employee.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public List<Employee> findAllEmployee() {
            Employee employee = new Employee();
            try {
                EntityManager entityManager = createEntityManager();
                TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
                List<Employee> employees = query.getResultList();
                return employees;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public void changeEmployee(int id, Employee employee) {
        try {
            EntityManager entityManager = createEntityManager();
            entityManager.getTransaction().begin();
            employee.setId(id);
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteEmployee(Employee employee) {
        try {
            EntityManager entityManager = createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}