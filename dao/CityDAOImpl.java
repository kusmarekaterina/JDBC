package dao;

import model.City;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static connection.HibernateUtil.createEntityManager;

public class CityDAOImpl implements CityDAO {
    @Override
    public void addInDataBase (City city) {
        try {
            EntityManager entityManager = createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(city);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public City getById(int id) {

        try {
            EntityManager entityManager = createEntityManager();
            return entityManager.find(City.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<City> findAllCity() {
        try {
            EntityManager entityManager = createEntityManager();
            TypedQuery<City> query = entityManager.createQuery("FROM City", City.class);
            List<City> cities = query.getResultList();
            return cities;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeCity(int id, City city) {
        try {
            EntityManager entityManager = createEntityManager();
            entityManager.getTransaction().begin();
            city.setCityId(id);
            entityManager.merge(city);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCity(City city) {
        try {
            EntityManager entityManager = createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(city);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
