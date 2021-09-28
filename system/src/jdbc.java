import javax.servlet.http.Cookie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc {

    public int add(User user){

        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO t_user(userName,password,phone)VALUES(?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/system","root","root");
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getPhone());
            result = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    };

    public String search(String userName) {
        Connection conn = null;
        PreparedStatement ps = null;
        String result = "";
        String sql = "SELECT id,userName,phone FROM t_user where userName=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/system","root","root");
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet result1 = ps.executeQuery();
            if (result1.next()){
                String id = result1.getString(1);
                String userName1 = result1.getString(2);
                String phone = result1.getString(3);
                result = id + "," + userName1 + "," + phone;
            }else {
                result = "没有找到";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    public List serachAll(){
        List<User> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM t_user";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/system","root","root");
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()){
                String id = result.getString(1);
                String userName = result.getString(2);
                String password = result.getString(3);
                String phone = result.getString(4);
                User users = new User(id,userName,password,phone);
                list.add(users);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }
}
