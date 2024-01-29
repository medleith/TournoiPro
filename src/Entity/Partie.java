package Entity;

import java.util.Date;

public class Partie {
    private int id;
    private Date dateMatch;
    private int score;
    private Equipe equipe1Id; // La clé étrangère vers Entity.Equipe
    private Equipe equipe2Id; // La clé étrangère vers Entity.Equipe
    private Tournoi tournoiId; // La clé étrangère vers Entity.Tournoi
}
