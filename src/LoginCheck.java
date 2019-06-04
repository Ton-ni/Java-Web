import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql .*;

public class LoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=GB18030");
        resp.getWriter().println(isClient(username,password));
    }
    //判断用户是否存在
    public static Boolean isClient(String client,String password){
        Connection con = null;
        PreparedStatement stat = null;
        ResultSet result = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mytest?serverTimezone=GMT";
        String splUser = "root";
        String sqlPassword = "";
        try {
            con = DriverManager.getConnection(url, splUser, sqlPassword);
            String sql = "SELECT client,password FROM client;";
            stat = con.prepareStatement(sql);
            result = stat.executeQuery();
            while (result.next()) {
                if (result.getString("client").equals(client) && result.getString("password").equals(password)) {
                    return true;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
                stat.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }
}
