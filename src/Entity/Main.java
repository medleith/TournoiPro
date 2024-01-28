package Entity;

import Service.TournoiService;

import java.sql.*;
import java.util.Date;

public class Main {
    static Statement ste;
    static Connection conn;
    static String url = "jdbc:mysql://localhost:3306/tournoipro";
    static String user = "root";
    static String pwd = "";


    public static void main(String[] args) {
      try {
            conn= DriverManager.getConnection(url,user,pwd);
            System.out.println("Connexion établie");
        }
        catch (SQLException e){
            System.out.println(e);
        }

       //DataBase cnx= DataBase.getCon();
       /* String req="INSERT INTO `tournoi` (`ID_Tournoi`, `Nom_Tournoi`, `Date_Debut`, `Date_Fin`, `Nbr_Equipe`) VALUES (NULL, 'Tournoi4', '2024-01-02', '2024-01-25', '7');";
        try {
            ste=conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("tournoi ajouté");

        }
        catch (SQLException e){
            System.out.println(e);
        }*/
      /*  Tournoi tournoi= new Tournoi("TNService",null,null,7);
        tournoi.setDateDebut(new Date(2026,01,12));
        TournoiService Service= new TournoiService();
        Service.AddTournoi(conn,tournoi);*/

    }
}