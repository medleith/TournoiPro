import Entity.Equipe;
import Entity.Participation;
import Entity.Tournoi;
import Entity.Utilisateur;
import Service.ParticipationService;
import Service.UtilisateurService;
import Utils.Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        /*Utilisateur u = new Utilisateur("Aziz","Aziz","ABC","Aziz","Aziz");
        UtilisateurService us = new UtilisateurService();
        u.setFirstName("BT");
        u.setID_Utilisateur(3);
        us.ajout(u);
        List<Utilisateur> lu = us.getListUtilisateur();
        for (Utilisateur ul:lu){
            System.out.println(ul);
        }

        Utilisateur u1 = us.recuperer(u);
        System.out.println(u1);*/

        Participation p = new Participation();
        Equipe e = new Equipe();
        e.setID_Equipe(1);
        Tournoi t = new Tournoi();
        t.setID_Tournoi(2);

        p.setEquipe(e);
        p.setTournoi(t);

        ParticipationService ps = new ParticipationService();
        ps.Annuler(p);
        /*List<Tournoi> lt = ps.RecupererTournois(1);
        for (Tournoi t1:lt){
            System.out.println(t1);
        }*/

    }
}
