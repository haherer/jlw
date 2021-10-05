package com.nicholas.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//读取配置文件内值
@Component
@ConfigurationProperties(prefix = "nicholashome")
public class School {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public School(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public School() {
    }
}
