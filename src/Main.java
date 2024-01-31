import Entity.Administrateur;
import Entity.Equipe;
import Entity.Joueur;
import Entity.Utilisateur;
import Service.AdministrateurService;
import Service.JoueurService;
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
/*      Administrateur a = new Administrateur("Aziz","Aziz","Aziz","Aziz");
        AdministrateurService as = new AdministrateurService();
        as.ajout(a);
        as.getListAdministrateur();
        List<Administrateur> lu = as.getListAdministrateur();
        for (Administrateur ul:lu){
            System.out.println(ul);
        }
        Administrateur a2 = as.recuperer(as.ajout(a));
        System.out.println(a2);
        as.supprimer(a2.getID_Admin());*/

       /* Equipe equipe = new Equipe();
        equipe.setID_Equipe(1);
        Joueur joueur = new Joueur("Aziz","Aziz","ABC","Aziz",equipe,10,11,"AC",1);
        JoueurService js = new JoueurService();
        int i = js.ajout(joueur);
        System.out.println(js.recuperer(i));
        List<Joueur> lu = js.getListJoueur();
        for (Joueur ul:lu){
            System.out.println(ul);
        }
        JoueurService js = new JoueurService();
        Joueur joueur = js.recuperer(33);
        joueur.setLogin("MODIFIED");
        js.modifier(joueur);
        System.out.println(js.recuperer(33));*/
    }
}
