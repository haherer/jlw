package reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Test01 {
    public static void main(String[] args) {
        try {
            FileReader fil = new FileReader("src/Test.properties");
            Properties pro = new Properties();
            pro.load(fil);
            fil.close();
            String val = pro.getProperty("Class");
            Class<?> c = Class.forName(val);
            Object obj = c.newInstance();
            System.out.println(obj);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

