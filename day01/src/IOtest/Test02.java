package IOtest;

public class Test02 {
    public static void main(String[] args) {
    Boy boy = new Boy(20 ,true ,"老王");
        System.out.println("年龄" + boy.getAge() + "性别" + boy.isSex() + "姓名" + boy.getName());
        //System.out.println(boy);
    Boy boy1 = new Boy();
        boy1.setAge(10);
        boy1.setName("老张");
        boy1.setSex(false);
        System.out.println(boy1);

    }
}


class Boy {
    private int age;
    private boolean sex;
    private String name;

    @Override
    public String toString() {
        return "姓名:" + this.name + "\n" + "性别：" + this.sex + "\n" + "年龄：" + this.age;
    }

    public Boy() {
    }

    public Boy(int age, boolean sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}