package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.DAO.EtudiantDAO;
import org.alherendro.absenceetudiant.entite.Etudiant;
import org.alherendro.absenceetudiant.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantDAO etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> obtenirTousLesEtudiants() throws SQLException {
        return etudiantRepository.obtenirTousLesEtudiants();
    }

    public Etudiant obtenirEtudiantParId(int id) throws SQLException {
        return etudiantRepository.obtenirEtudiantParId(id);
    }

    public void ajouterEtudiant(Etudiant etudiant) throws SQLException {
        etudiantRepository.ajouterEtudiant(etudiant);
    }

    public void modifierEtudiant(Etudiant etudiant) throws SQLException {
        etudiantRepository.modifierEtudiant(etudiant);
    }

    public void supprimerEtudiant(int id) throws SQLException {
        etudiantRepository.supprimerEtudiant(id);
    }
}
