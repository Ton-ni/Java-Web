package serve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class login {

    //判断用户是否存在
    public  Boolean isClient(String client,String password){
        MysqlOperate sql = new MysqlOperate();
        sql.myConnection();
        if (sql.isClient(username,password)){
            resp.getWriter().println(username+"登陆成功");
        }else {
            resp.getWriter().println("登陆失败");
        }
        try {
            String sql = "SELECT client,password FROM client;";
            prestate = con.prepareStatement(sql);
            result = prestate.executeQuery();
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
                prestate.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
