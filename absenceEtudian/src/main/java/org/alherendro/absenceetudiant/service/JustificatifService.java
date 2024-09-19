package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.DAO.JustificatifDAO;
import org.alherendro.absenceetudiant.entite.Justificatif;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class JustificatifService {

    private final JustificatifDAO justificatifDAO;

    public JustificatifService(JustificatifDAO justificatifDAO) {
        this.justificatifDAO = justificatifDAO;
    }

    public void ajouterJustificatif(Justificatif justificatif) throws SQLException {
        justificatifDAO.ajouterJustificatif(justificatif);
    }

    public Justificatif obtenirJustificatifParId(int id) throws SQLException {
        return justificatifDAO.obtenirJustificatifParId(id);
    }

    public List<Justificatif> obtenirTousLesJustificatifs() throws SQLException {
        return justificatifDAO.obtenirTousLesJustificatifs();
    }

    public void modifierJustificatif(Justificatif justificatif) throws SQLException {
        justificatifDAO.modifierJustificatif(justificatif);
    }

    public void supprimerJustificatif(int id) throws SQLException {
        justificatifDAO.supprimerJustificatif(id);
    }
}
