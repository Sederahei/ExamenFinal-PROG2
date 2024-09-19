package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.entite.Niveau;

import java.sql.SQLException;
import java.util.List;

public interface NiveauDAO {
    void ajouterNiveau(Niveau niveau) throws SQLException;
    Niveau obtenirNiveauParId(int id) throws SQLException;
    List<Niveau> obtenirTousLesNiveaux() throws SQLException;
    void modifierNiveau(Niveau niveau) throws SQLException;
    void supprimerNiveau(int id) throws SQLException;
}
