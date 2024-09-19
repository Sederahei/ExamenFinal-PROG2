package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.entite.Group;
import java.sql.SQLException;
import java.util.List;

public interface GroupDAO {
    void ajouterGroup(Group group) throws SQLException;
    Group obtenirGroupParId(int id) throws SQLException;
    List<Group> obtenirTousLesGroupes() throws SQLException;
    void modifierGroup(Group group) throws SQLException;
    void supprimerGroup(int id) throws SQLException;
}
