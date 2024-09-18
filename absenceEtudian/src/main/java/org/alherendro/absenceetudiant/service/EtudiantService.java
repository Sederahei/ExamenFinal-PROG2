package org.alherendro.absenceetudiant.service;


import org.alherendro.absenceetudiant.DAO.EtudiantDAO;
import org.alherendro.absenceetudiant.DAO.EtudiantDAOImpl;
import org.alherendro.absenceetudiant.entite.Etudiant;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EtudiantService {

    private EtudiantDAO etudiantDAO;

    public EtudiantService(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public void modifierEtudiant(Etudiant etudiant) throws SQLException {
        etudiantDAO.update(etudiant);


    }

    public List<Etudiant> obtenirTousLesEtudiants() throws SQLException {

        return etudiantDAO.getAll();
    }

    public Etudiant obtenirEtudiantParId(int id) throws SQLException {

            return etudiantDAO.getById(id);

    }

    public void supprimerEtudiant(int id) throws SQLException {
            etudiantDAO.delete(id);
        }
    }

