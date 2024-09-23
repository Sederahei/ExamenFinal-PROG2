/*package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.DAO.EtudiantDAO;
import org.alherendro.absenceetudiant.entite.Etudiant;
import org.alherendro.absenceetudiant.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EtudiantService {


    public String genererIdEtudiant(int idNiveau) {
        String prefix = "";
        if (idNiveau == 1) {  // L2
            prefix = "std23";
        } else if (idNiveau == 2) {  // L3
            prefix = "std20";
        }
        int studentCount = obtenirNombreEtudiants();
        return prefix + String.format("%03d", studentCount + 1);
    }

    private int obtenirNombreEtudiants() {
        return 0;
    }

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
        etudiant.setStd(genererIdEtudiant((int) etudiant.getNiveau().getId()));
        etudiantRepository.ajouterEtudiant(etudiant);
    }

    public void modifierEtudiant(Etudiant etudiant) throws SQLException {
        etudiantRepository.modifierEtudiant(etudiant);
    }

    public void supprimerEtudiant(int id) throws SQLException {
        etudiantRepository.supprimerEtudiant(id);
    }
}*/
package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.entite.Etudiant;
import org.alherendro.absenceetudiant.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public void ajouterEtudiant(Etudiant etudiant) throws SQLException {
        etudiantRepository.ajouterEtudiant(etudiant);
    }

    public Etudiant obtenirEtudiantParId(int id) throws SQLException {
        return etudiantRepository.obtenirEtudiantParId(id);
    }

    public List<Etudiant> obtenirTousLesEtudiants() throws SQLException {
        return etudiantRepository.obtenirTousLesEtudiants();
    }

    public void modifierEtudiant(Etudiant etudiant) throws SQLException {
        etudiantRepository.modifierEtudiant(etudiant);
    }

    public void supprimerEtudiant(int id) throws SQLException {
        etudiantRepository.supprimerEtudiant(id);
    }
}

