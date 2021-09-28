import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName;
        userName = req.getParameter("userName");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (userName == ""){
            out.print("不能为空");
        }else {
            jdbc jdbc = new jdbc();
            String result = jdbc.search(userName);
            out.print(result);
        }
    }
}
