
package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.DAO.NiveauDAO;
import org.alherendro.absenceetudiant.entite.Niveau;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NiveauService {
    private final NiveauDAO niveauDAO;

    public NiveauService(NiveauDAO niveauDAO) {
        this.niveauDAO = niveauDAO;
    }

    public void ajouterNiveau(Niveau niveau) throws SQLException {
        niveauDAO.ajouterNiveau(niveau);
    }

    public Niveau obtenirNiveauParId(int id) throws SQLException {
        return niveauDAO.obtenirNiveauParId(id);
    }

    public List<Niveau> obtenirTousLesNiveaux() throws SQLException {
        return niveauDAO.obtenirTousLesNiveaux();
    }

    public void modifierNiveau(Niveau niveau) throws SQLException {
        niveauDAO.modifierNiveau(niveau);
    }

    public void supprimerNiveau(int id) throws SQLException {
        niveauDAO.supprimerNiveau(id);
    }
}
