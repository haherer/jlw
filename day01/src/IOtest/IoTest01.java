package IOtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.StreamSupport;

public class IoTest01 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = null;

        try {
             fis = new FileInputStream("Abcd");

//             while (true) {
//                 int readData = fis.read();
//                 if (readData == -1) {
//                     break;
//                 }
//                 System.out.println(readData);
//             }

            int readData = 0;
            while((readData = fis.read()) != -1){
                System.out.println(readData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                fis.close();
            }
        }

    }
}
