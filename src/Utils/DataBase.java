package Utils;

import java.sql.*;

public class DataBase {
    private static Connection con;

    public static Connection getCon(){
        if (con==null) {
            String url = "jdbc:mysql://localhost:3306/tournoipro";
            String user = "root";
            String pwd = "";
            try {
                con= DriverManager.getConnection(url,user,pwd);
                System.out.println(con==null);
                System.out.println("Connexion établie");
            }
            catch (SQLException e){
                System.out.println(e);
            }


        }
        return con;}

}
