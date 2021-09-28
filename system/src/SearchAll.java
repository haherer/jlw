import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=utf-8");
            jdbc jdbc = new jdbc();
            List<User> list = jdbc.serachAll();
            for (User lists : list) {
                PrintWriter out = resp.getWriter();
                out.print(lists.getId() + ",");
                out.print(lists.getUserName()+ ",");
                out.print(lists.getPassword()+ ",");
                out.print(lists.getPhone()+ "<br>");
            }
    }
}
