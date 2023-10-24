package ru.bzrktm.springBoot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "name should be between 2 and 30 characters")
    private String name;
    @Column(name = "lastName")
    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 2, max = 35, message = "last name should be between 2 and 35 characters")
    private String lastName;
    @Column(name = "age")
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    public User() {
    }

    public User(long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User: \n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
