package Service;

import Entity.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public interface IService <T>{
    public int ajout (T t) throws SQLException;
    public void supprimer (int t) throws SQLException;
    public void modifier (T t) throws SQLException;
    public T recuperer (int t) throws SQLException;

}
