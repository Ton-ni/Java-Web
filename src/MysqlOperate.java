//加载驱动-建立连接-操作语句-处理语句-获得返回值-关闭连接
import java.sql.*;

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
    //查询车辆信息
    public String listCar(){
        String carInformation ="id  brand  price"+"\n";
        try{
            prestate = con.prepareStatement("select id,brand,price from car;");
            result = prestate.executeQuery();
            while (result.next()) {
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

    //判断用户是否存在
    public  Boolean isClient(String client,String password){
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

    //

    public static void main(String[] args) {
        MysqlOperate oper1 = new MysqlOperate();
        oper1.myConnection();
        System.out.println(oper1.listCar());
    }


}
