package com.work.entity;

public class User {
    private String name;
    private String pass;
    private int age;
    private String role;



    public User() {
    }

    public User(String name, String pass, int age, String role) {
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.role = role;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + pass + " " + age + " " + role;
    }
}
