package com.nicholas.bean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jiang") //绑定配置文件中的前缀
public class Jiang {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Jiang{" +
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

    public Jiang(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Jiang() {
    }
}
