package Service;

import Entity.Equipe;
import Utils.Datasource;

import java.sql.SQLException;
import java.sql.Statement;

public class EquipeService implements IService<Equipe> {

    @Override
    public int ajout(Equipe equipe) throws SQLException {
        int generatedID = 0;
        try {
            String request = "INSERT INTO `equipe`(`ID_Equipe`, `Nom_Equipe`, `Nbr_Joueur`) " +
                    "VALUES ('" + equipe.getID_Equipe() + "','" + equipe.getNom_Equipe() + "','" + equipe.getNbr_Joueur() + "')";
            Statement statement = Datasource.getInstance().getCon().createStatement();
            generatedID = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return generatedID;
    }

    @Override
    public void supprimer(int idEquipe) throws SQLException {
        try {
            String request = "DELETE FROM `equipe` WHERE `ID_Equipe` ='" + idEquipe + "'";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    @Override
    public void modifier(Equipe equipe) throws SQLException {
        try {
            String request = "UPDATE `equipe` SET `ID_Equipe`='" + equipe.getID_Equipe() + "',`Nom_Equipe`='" + equipe.getNom_Equipe() + "',`Nbr_Joueur`='" + equipe.getNbr_Joueur() + "' WHERE `ID_Equipe`='" + equipe.getID_Equipe() + "'";
            Datasource.getInstance().getCon().createStatement().executeUpdate(request);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    @Override
    public List<Equipe> recuperer(int idEquipe) throws SQLException {
        List<Equipe> equipeList = new ArrayList<>();
        try {
            String request = "SELECT * FROM `equipe` WHERE `ID_Equipe`='" + idEquipe +"'";
            PreparedStatement preparedStatement = Datasource.getInstance().getCon().prepareStatement(request);
            preparedStatement.setInt(1, idEquipe);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int ID_Equipe = resultSet.getInt("ID_Equipe");
                String Nom_Equipe = resultSet.getString("Nom_Equipe");
                int Nbr_Joueur = resultSet.getInt("Nbr_Joueur");

                equipe = new Equipe(ID_Equipe, Nom_Equipe, Nbr_Joueur);
                equipeList.add(equipe);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return equipeList;
    }
}

