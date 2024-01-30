package Service;

import Entity.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public interface IService <T>{
    public void ajout (T t) throws SQLException;
    public void supprimer (T t) throws SQLException;
    public void modifier (T t) throws SQLException;
    public T recuperer (T t) throws SQLException;

}
