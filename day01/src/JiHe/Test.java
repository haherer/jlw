package JiHe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        Collection ay = new ArrayList();
//        ay.add(123);
//        ay.add(123);
//
//
//        Iterator it = ay.iterator();
//
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

        List list = new ArrayList();

        for (int i = 0; i < 10; i++) {

            list.add(i,i);
        }

        Iterator it2 = list.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
