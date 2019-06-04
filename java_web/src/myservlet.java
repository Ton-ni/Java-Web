import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;

/**
 * @author:Administrator
 * @date: 2019/6/2
 * @description:
 */
public class myservlet extends HttpServlet {
    public void init(ServletConfig arg0) throws ServletException {
        System.out.println("==========init========");
    }
    public void service(ServletRequest arg0, ServletResponse arg1)
            throws ServletException, IOException {
        System.out.println("hehe");
    }
    public void destroy() {
        System.out.println("******destroy**********");
    }
    public ServletConfig getServletConfig() {

        return null;
    }

}
