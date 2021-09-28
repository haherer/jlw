package com.jlw.domain;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Date date;

    public Student() { }

    public Student(Integer id, String name, Integer age, String email, Date date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
