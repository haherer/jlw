import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class FindSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            Enumeration names = session.getAttributeNames();
            while(names.hasMoreElements()){
                String name = (String) names.nextElement();
                int num = (int)session.getAttribute(name);
                resp.setContentType("text/html;charset=utf-8");
                out.println(name + "," + num + "<br>");
            }
    }
}
