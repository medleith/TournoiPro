package Service;

import Entity.Participation;
import Utils.Datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParticipationService implements IService<Participation>{
    Connection con;
    Statement statement;
    String request;
    ResultSet resultSet;

    @Override
    public void ajout(Participation participation) throws SQLException {
        try
        {
            request ="INSERT INTO `participation`(`ID_Tournoi`, `ID_Equipe`) " + "VALUES ('"+participation.getTournoi().getID_Tournoi()+"','"+participation.getEquipe().getID_Equipe()+"')";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request);
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
    }

    @Override
    public void supprimer(Participation participation) throws SQLException {
        try
        {
            request ="DELETE FROM `participation` WHERE `ID_Tournoi` ='"+participation.getTournoi().getID_Tournoi()+"' and `ID_Equipe` ='"+participation.getEquipe().getID_Equipe()+"'";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request);
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
    }

    @Override
    public void modifier(Participation participation) throws SQLException {

    }

    @Override
    public Participation recuperer(Participation participation) throws SQLException {
        

        return null;
    }
}
