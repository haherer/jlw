public class DayTest {
    public static void main(String[] args) {
        Day day = new Day();
        day.setAge(10);
        day.setName("haha");
        System.out.println(day.getAge() + "\n" + day.getName());

        Day day1 = new Day(10, "hehe");
        System.out.println(day1.getAge() + "\n" + day1.getName());
    }
}

class Day {
    int age;
    String name;

    public Day(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Day() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


