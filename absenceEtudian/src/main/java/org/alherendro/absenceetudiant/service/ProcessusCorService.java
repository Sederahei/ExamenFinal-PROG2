package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.DAO.ProcessusCorDAO;
import org.alherendro.absenceetudiant.entite.Processus_Cor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProcessusCorService {

    private final ProcessusCorDAO processusCorDAO;

    @Autowired
    public ProcessusCorService(ProcessusCorDAO processusCorDAO) {
        this.processusCorDAO = processusCorDAO;
    }

    public void ajouterProcessusCor(Processus_Cor processusCor) throws SQLException {
        processusCorDAO.ajouterProcessusCor(processusCor);
    }

    public Processus_Cor obtenirProcessusCorParId(int id) throws SQLException {
        return processusCorDAO.obtenirProcessusCorParId(id);
    }

    public List<Processus_Cor> obtenirTousLesProcessusCor() throws SQLException {
        return processusCorDAO.obtenirTousLesProcessusCor();
    }

    public void modifierProcessusCor(Processus_Cor processusCor) throws SQLException {
        processusCorDAO.modifierProcessusCor(processusCor);
    }

    public void supprimerProcessusCor(int id) throws SQLException {
        processusCorDAO.supprimerProcessusCor(id);
    }
}
