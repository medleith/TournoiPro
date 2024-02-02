package Service;
import Entity.*;
import Entity.Joueur;
import Entity.Joueur;
import Utils.Datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JoueurService implements IService<Joueur> {
    UtilisateurService utilisateurService = new UtilisateurService();
    Utilisateur utilisateur;
    PreparedStatement preparedStatement;
    String request;
    ResultSet resultSet;
    public Utilisateur joueurToUtilisateur(Joueur joueur){
        return new Utilisateur(joueur.getLogin(),joueur.getPassword(),joueur.getType(),joueur.getFirstName(),joueur.getLastName());
    }
    @Override
    public int ajout(Joueur joueur) throws SQLException {
        int generatedID=0;
        try
        {
            generatedID = utilisateurService.ajout(joueurToUtilisateur(joueur));
            System.out.println("ID : "+generatedID);
            request ="INSERT INTO `joueur`(`ID_Joueur`, `ID_Equipe`, `Nbr_Buts`, `Nbr_Assists`, `Position`, `Capitaine`) " +
                    "VALUES ('"+generatedID+"','"+joueur.getEquipe().getID_Equipe()+"','"+joueur.getNbr_Buts()+"','"+joueur.getNbr_Assists()+"','"+joueur.getPosition()+"','"+joueur.getCapitaine()+"')";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
        return generatedID;
    }

    @Override
    public void supprimer(int idJoueur) throws SQLException {
        try
        {
            //request ="DELETE FROM `joueur` WHERE `ID_Joueur` ='"+idJoueur+"'";
            //Datasource.getInstance().getCon().createStatement().executeUpdate(request);
            //ON DELETE CASCADE
            utilisateurService.supprimer(idJoueur);
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
    }

    @Override
    public void modifier(Joueur joueur) throws SQLException {
        try{
            //utilisateurService.modifier(joueurToUtilisateur(joueur));
            request = "UPDATE joueur,utilisateur SET ID_Equipe ='"+joueur.getEquipe().getID_Equipe()+"',Nbr_Buts ='"+joueur.getNbr_Buts()+"',Nbr_Assists ='"+joueur.getNbr_Assists()+"',Position ='"+joueur.getPosition()+"',Capitaine ='"+joueur.getCapitaine()+"'" +
                      ",Login ='"+joueur.getLogin()+"', Password ='"+joueur.getPassword()+"', Type ='"+joueur.getType()+"', FirstName ='"+joueur.getFirstName()+"',LastName ='"+joueur.getLastName()+"' WHERE ID_Joueur ='"+joueur.getID_Joueur()+"' AND ID_Utilisateur = '"+joueur.getID_Joueur()+"'";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request);
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
    }

    @Override
    public Joueur recuperer(int idJoueur) throws SQLException {
        Joueur joueur = null;
        try{
            request = "SELECT * FROM utilisateur,joueur,equipe WHERE ID_Joueur = ID_Utilisateur AND ID_Joueur ='"+idJoueur+"' AND equipe.ID_Equipe = joueur.ID_Equipe;";
            resultSet = Datasource.getInstance().getCon().createStatement().executeQuery(request);
            while (resultSet.next()){
                 joueur = getJoueur();
            }
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
        return joueur;
    }
    public List<Joueur> getListJoueur() throws SQLException {
        List<Joueur> JoueurList = new ArrayList<>();
        Joueur joueur;

        try{
            request = "SELECT * FROM utilisateur,joueur,equipe WHERE ID_Joueur = ID_Utilisateur AND equipe.ID_Equipe = joueur.ID_Equipe;";
            resultSet = Datasource.getInstance().getCon().createStatement().executeQuery(request);
            while (resultSet.next()){
                joueur = getJoueur();
                JoueurList.add(joueur);
                }
        }
        catch (SQLException exception){
            System.out.println(exception);
        };
        return JoueurList;
    }

    private Joueur getJoueur() throws SQLException {
        Joueur joueur;
        Equipe equipe = new Equipe(resultSet.getInt(13),resultSet.getString(14),resultSet.getInt(15));
        joueur=new Joueur(resultSet.getInt(1),resultSet.getString (2), resultSet.getString (3), resultSet.getString (4), resultSet.getString (5), resultSet.getString (6), equipe, resultSet.getInt (9), resultSet.getInt (10), resultSet.getString (11), resultSet.getInt(12));
        return joueur;
    }
}
