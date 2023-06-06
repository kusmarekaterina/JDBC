package model;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table (name = "employee")
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column
    private String gender;
    @Column
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String gender, int age, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName + " " + gender + " " + age + " " + city + "\n";
    }
}