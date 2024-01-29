/*package Service;

import Entity.Tournoi;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TournoiService   {
    static Statement ste;
    static Connection conn;
    public void AddTournoi(Connection conn,Tournoi Tn) {

        String req="INSERT INTO `tournoi` (`ID_Tournoi`, `Nom_Tournoi`, `Date_Debut`, `Date_Fin`, `Nbr_Equipe`) VALUES (NULL, ?, ?, ?, ?);";
        try {
            PreparedStatement ste=conn.prepareStatement(req);

            ste.setString(1,Tn.getNom());
            ste.setDate(2,parseDate(Tn.getDateDebut().toString()));
            System.out.println(Tn.getDateDebut());
            ste.setDate(3, (Date) Tn.getDateFin());
            ste.setInt(4,Tn.getNombreEquipes());
            ste.executeUpdate();
            System.out.println("tournoi ajouté");
        }
        catch (
                SQLException e){
            System.out.println(e);
        }
    };

    public static Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(dateString);
            return new Date(parsedDate.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Format de date invalide", e);
        }

    }





}*/
