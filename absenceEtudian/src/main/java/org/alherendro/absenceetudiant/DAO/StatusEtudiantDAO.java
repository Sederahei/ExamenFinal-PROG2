package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.entite.Status_etudiant;

import java.sql.SQLException;
import java.util.List;

public interface StatusEtudiantDAO {
    void ajouterStatusEtudiant(Status_etudiant statusEtudiant) throws SQLException;
    Status_etudiant obtenirStatusEtudiantParId(int id) throws SQLException;
    List<Status_etudiant> obtenirTousLesStatusEtudiants() throws SQLException;
    void modifierStatusEtudiant(Status_etudiant statusEtudiant) throws SQLException;
    void supprimerStatusEtudiant(int id) throws SQLException;
}
