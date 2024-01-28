package Entity;

public class Joueur {
    private int ID_Joueur;
    private Equipe Equipe;
    private int Nbr_Buts;
    private int Nbr_Assists;
    private String Position;
    private boolean Capitaine;

    public int getID_Joueur() {
        return ID_Joueur;
    }

    public void setID_Joueur(int ID_Joueur) {
        this.ID_Joueur = ID_Joueur;
    }

    public Entity.Equipe getEquipe() {
        return Equipe;
    }

    public void setEquipe(Entity.Equipe equipe) {
        Equipe = equipe;
    }

    public int getNbr_Buts() {
        return Nbr_Buts;
    }

    public void setNbr_Buts(int nbr_Buts) {
        Nbr_Buts = nbr_Buts;
    }

    public int getNbr_Assists() {
        return Nbr_Assists;
    }

    public void setNbr_Assists(int nbr_Assists) {
        Nbr_Assists = nbr_Assists;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public boolean isCapitaine() {
        return Capitaine;
    }

    public void setCapitaine(boolean capitaine) {
        Capitaine = capitaine;
    }

    public Joueur(int ID_Joueur, Entity.Equipe equipe, int nbr_Buts, int nbr_Assists, String position, boolean capitaine) {
        this.ID_Joueur = ID_Joueur;
        Equipe = equipe;
        Nbr_Buts = nbr_Buts;
        Nbr_Assists = nbr_Assists;
        Position = position;
        Capitaine = capitaine;
    }
}
