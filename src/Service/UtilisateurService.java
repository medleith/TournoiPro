package Service;

import Entity.Utilisateur;
import Utils.Datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UtilisateurService implements IService<Utilisateur> {
    Connection con;
    Statement statement;
    String request;
    ResultSet resultSet;
    public void Utilisateur (){
        con = Datasource.getInstance().getCon();
    }
    @Override
    public void ajout(Utilisateur utilisateur) throws SQLException {
        try
        {
            request ="INSERT INTO `utilisateur`(`Login`, `Password`, `Type`, `FirstName`, `LastName`) " + "VALUES ('"+utilisateur.getLogin()+"','"+utilisateur.getPassword()+"','"+utilisateur.getType()+"','"+utilisateur.getFirstName()+"','"+utilisateur.getLastName()+"')";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request);
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
    }
    @Override
    public void supprimer(Utilisateur utilisateur) throws SQLException {
        try
        {
            request ="DELETE FROM `utilisateur` WHERE `ID_Utilisateur` ='"+utilisateur.getID_Utilisateur()+"'";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request);
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
    }
    @Override
    public void modifier(Utilisateur utilisateur) throws SQLException {
        try{
            request = "UPDATE `utilisateur` SET `Login`='"+utilisateur.getLogin()+"',`Password`='"+utilisateur.getPassword()+"',`Type`='"+utilisateur.getType()+"',`FirstName`='"+utilisateur.getFirstName()+"',`LastName`='"+utilisateur.getLastName()+"' WHERE `ID_Utilisateur`='"+utilisateur.getID_Utilisateur()+"'";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request);
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
    }
    @Override
    public Utilisateur recuperer(Utilisateur utilisateur) throws SQLException {
        Utilisateur util = null;
        try{
            request = "SELECT * FROM `utilisateur` WHERE `ID_Utilisateur`='"+utilisateur.getID_Utilisateur()+"'";
            resultSet = Datasource.getInstance().getCon().createStatement().executeQuery(request);
            while (resultSet.next()){
                util=new Utilisateur(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            }
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
        return util;
    }
    public List<Utilisateur> getListUtilisateur() throws SQLException {
        List<Utilisateur> utilisateurList = new ArrayList<>();
        Utilisateur utilisateur;
        try{
            request = "SELECT * FROM `utilisateur`";
            resultSet = Datasource.getInstance().getCon().createStatement().executeQuery(request);
            while (resultSet.next()){
                utilisateur=new Utilisateur(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
                utilisateurList.add(utilisateur);
            }
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
        return utilisateurList;
    }
}