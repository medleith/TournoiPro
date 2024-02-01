package Service;

import Entity.Utilisateur;
import Utils.Datasource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UtilisateurService implements IService<Utilisateur> {
    String request;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    @Override
    public int ajout(Utilisateur utilisateur) throws SQLException {
        int generatedID=0;
        try
        {
            request ="INSERT INTO `utilisateur`(`Login`, `Password`, `Type`, `FirstName`, `LastName`) " + "VALUES ('"+utilisateur.getLogin()+"','"+utilisateur.getPassword()+"','"+utilisateur.getType()+"','"+utilisateur.getFirstName()+"','"+utilisateur.getLastName()+"')";
            preparedStatement =  Datasource.getInstance().getCon().prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            //generatedID = preparedStatement.getGeneratedKeys().getInt(1) ;
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                generatedID = resultSet.getInt(1);
            }
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
        return generatedID;
    }
    @Override
    public void supprimer(int idUtilisateur) throws SQLException {
        try
        {
            request ="DELETE FROM `utilisateur` WHERE `ID_Utilisateur` ='"+idUtilisateur+"'";
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
    public Utilisateur recuperer(int idUtilisateur) throws SQLException {
        Utilisateur utilisateur = null;
        try{
            request = "SELECT * FROM `utilisateur` WHERE `ID_Utilisateur`='"+idUtilisateur+"'";
            resultSet = Datasource.getInstance().getCon().createStatement().executeQuery(request);
            while (resultSet.next()){
                utilisateur=new Utilisateur(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            }
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
        return utilisateur;
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