import Entity.Administrateur;
import Entity.Utilisateur;
import Service.AdministrateurService;
import Service.UtilisateurService;
import Utils.Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws SQLException {
/*      Utilisateur u = new Utilisateur("Aziz","Aziz","ABC","Aziz","Aziz");
        UtilisateurService us = new UtilisateurService();
        u.setFirstName("BT");
        u.setID_Utilisateur(3);
        us.modifier(u);
        List<Utilisateur> lu = us.getListUtilisateur();
        for (Utilisateur ul:lu){
            System.out.println(ul);
        }

        Utilisateur u1 = us.recuperer(3);
        System.out.println(u1);*/
        Administrateur a = new Administrateur("Aziz","Aziz","Aziz","Aziz");
        AdministrateurService as = new AdministrateurService();
        as.ajout(a);
        as.getListAdministrateur();
        List<Administrateur> lu = as.getListAdministrateur();
        for (Administrateur ul:lu){
            System.out.println(ul);
        }
        Administrateur a2 = as.recuperer(as.ajout(a));
        System.out.println(a2);
        as.supprimer(a2.getID_Admin());
    }
}
