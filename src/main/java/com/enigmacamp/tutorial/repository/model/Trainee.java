package com.enigmacamp.tutorial.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "trainees")
public class Trainee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date joinDate;
    private Integer isActive;

    public Trainee(String firstName, String lastName, Integer age, Date joinDate, Integer isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.joinDate = joinDate;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", joinDate=" + joinDate +
                ", isActive=" + isActive +
                '}';
    }
}
