package IOtest;

import java.util.Objects;

public class Test01 {
    private int age;
    private String name;
    void Test01(){

    }
    void Test01(int age){

    }

    @Override
    public String toString() {
        return "Test01{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test01 test01 = (Test01) o;
        return age == test01.age && Objects.equals(name, test01.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
