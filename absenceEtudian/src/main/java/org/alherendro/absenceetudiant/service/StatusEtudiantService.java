package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.DAO.StatusEtudiantDAO;
import org.alherendro.absenceetudiant.entite.Status_etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StatusEtudiantService {

    private final StatusEtudiantDAO statusEtudiantDAO;

    @Autowired
    public StatusEtudiantService(StatusEtudiantDAO statusEtudiantDAO) {
        this.statusEtudiantDAO = statusEtudiantDAO;
    }

    public void ajouterStatusEtudiant(Status_etudiant statusEtudiant) throws SQLException {
        statusEtudiantDAO.ajouterStatusEtudiant(statusEtudiant);
    }

    public Status_etudiant obtenirStatusEtudiantParId(int id) throws SQLException {
        return statusEtudiantDAO.obtenirStatusEtudiantParId(id);
    }

    public List<Status_etudiant> obtenirTousLesStatusEtudiants() throws SQLException {
        return statusEtudiantDAO.obtenirTousLesStatusEtudiants();
    }

    public void modifierStatusEtudiant(Status_etudiant statusEtudiant) throws SQLException {
        statusEtudiantDAO.modifierStatusEtudiant(statusEtudiant);
    }

    public void supprimerStatusEtudiant(int id) throws SQLException {
        statusEtudiantDAO.supprimerStatusEtudiant(id);
    }
}
