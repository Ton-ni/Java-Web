package db;//加载驱动-建立连接-操作语句-处理语句-获得返回值-关闭连接
import java.sql.*;
import java.util.ArrayList;
import /src.javabean;

public class MysqlOperate {
    private Connection con = null;
    private PreparedStatement prestate = null;
    private ResultSet result = null;

    public Connection myConnection() {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mytest?serverTimezone=GMT";
        String splUser = "root";
        String sqlPassword = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, splUser, sqlPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //查询
    public ArrayList query(){
        ArrayList<client> clientSum = new ArrayList();
        try{
            prestate = con.prepareStatement("select client,password from client;");
            result = prestate.executeQuery();
            while (result.next()) {
                client.add()
                carInformation+=result.getInt("id")+"  "+result.getString("brand")+"  "+result.getInt("price")+"\n";

            }
        }catch(SQLException e) {
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
        return carInformation;

    }


}
