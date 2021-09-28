package IOtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IoTest02 {
    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream("Abcd");
            byte[] bytes = new byte[4];
            while (true){
                int no = file.read(bytes);
                if(no == -1){
                    break;
                }
                System.out.print(new String(bytes,0,no));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (file != null) {
                file.close();
            }
        }
    }
}
