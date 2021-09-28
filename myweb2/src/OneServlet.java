import com.sun.org.apache.xpath.internal.objects.XObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String str = "haha<br/>haha<br/>111<br/>";
//        String str1 = "hahah嘎嘎嘎<br/>haha<br/>111<br/>";

        resp.sendRedirect("https://www.baidu.com");
        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.print(str);
//        out.print(str1);
    }
}
