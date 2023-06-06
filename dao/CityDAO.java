package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDAO {
    void addInDataBase (City city);

    City getById (int id);

    List<City> findAllCity ();

    void changeCity (int id, City city);

    void deleteCity (City city);
}
