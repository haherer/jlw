import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String) paramNames.nextElement();
            String value = req.getParameter(paramName);
            System.out.println("参数名称:" + paramName + "值:" + value);

        }
    }
}
