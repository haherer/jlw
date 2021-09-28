import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class username extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String userName,password,phone;
            int result = 0;
            userName = req.getParameter("userName");
            password = req.getParameter("password");
            phone = req.getParameter("phone");

            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            if (userName == "" || password == "" || phone == ""){
                out.print("用户名、密码、手机号不能为空");
            }else {
                User user = new User(null,userName,password,phone);
                result = new jdbc().add(user);

                if (result == 1){
                    out.print("注册成功");
                }else {
                    out.print("注册失败");
                }
            }


    }
}
