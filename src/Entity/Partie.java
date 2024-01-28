package Entity;

import java.util.Date;

public class Partie {
    private int id;
    private Date dateMatch;
    private int score;
    private int equipe1Id; // La clé étrangère vers Entity.Equipe
    private int equipe2Id; // La clé étrangère vers Entity.Equipe
    private int tournoiId; // La clé étrangère vers Entity.Tournoi
}
