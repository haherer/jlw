package IOtest;

public class Test03 {
    public static void main(String[] args) {
        Boy boy2 = new Boy();
        Book book = new Book();
    }
}
class Book{
    private Boy boy;
    private int mon;

    public Book() {
    }

    public Book(Boy boy, int mon) {
        this.boy = boy;
        this.mon = mon;
    }

    public Boy getBoy() {
        return boy;
    }

    public void setBoy(Boy boy) {
        this.boy = boy;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }
}
