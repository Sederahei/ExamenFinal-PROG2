package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.entite.Etudiant;

import java.sql.SQLException;
import java.util.List;

public interface EtudiantDAO {
    void ajouterEtudiant(Etudiant etudiant) throws SQLException;

    Etudiant obtenirEtudiantParId(int id) throws SQLException;

    List<Etudiant> obtenirTousLesEtudiants() throws SQLException;

    void modifierEtudiant(Etudiant etudiant) throws SQLException;

    void supprimerEtudiant(int id) throws SQLException;
}
