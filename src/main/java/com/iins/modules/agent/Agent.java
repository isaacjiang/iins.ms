package com.iins.modules.agent;

import org.springframework.data.annotation.Id;

public class Agent {
    @Id
    private String id;

    private String firstname;
    private String lastname;
    private int age;

    public Agent() {
    }

    public Agent(String custId, String firstname, String lastname, int age) {
        this.id = custId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Agent(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String custId) {
        this.id = custId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String info = String.format("custId = %d, firstname = %s, lastname = %s, age = %d", id, firstname, lastname, age);
        return info;
    }
}