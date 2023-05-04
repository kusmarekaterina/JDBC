package model;

public class City {

    private int city_id;
    private String city_name;


    public City(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public City(int city_id) {
        this.city_id = city_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    @Override
    public String toString() {
        return city_id + " " + city_name;
    }
}