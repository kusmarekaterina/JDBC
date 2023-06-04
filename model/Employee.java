package model;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table (name = "employees")
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String gender;
    @Column
    private int age;
    @Column
    private int city;

    public Employee() {
    }

    public Employee(int id, String first_name, String last_name, String gender, int age, int city) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee(String first_name, String last_name, String gender, int age, int city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getCity() {
        return city;
    }

    @Override
    public String toString() {
        return id + " " + first_name + " " + last_name + " " + gender + " " + age + " " + city + "\n";
    }
}