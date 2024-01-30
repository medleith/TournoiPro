import Entity.Utilisateur;
import Service.UtilisateurService;
import Utils.Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        Utilisateur u = new Utilisateur("Aziz","Aziz","ABC","Aziz","Aziz");
        UtilisateurService us = new UtilisateurService();
        u.setFirstName("BT");
        u.setID_Utilisateur(3);
        us.modifier(u);
        List<Utilisateur> lu = us.getListUtilisateur();
        for (Utilisateur ul:lu){
            System.out.println(ul);
        }

        Utilisateur u1 = us.recuperer(u);
        System.out.println(u1);


    }
}
