package org.alherendro.absenceetudiant.DAO;

import org.alherendro.absenceetudiant.entite.Processus_Cor;

import java.sql.SQLException;
import java.util.List;

public interface ProcessusCorDAO {
    void ajouterProcessusCor(Processus_Cor processusCor) throws SQLException;
    Processus_Cor obtenirProcessusCorParId(int id) throws SQLException;
    List<Processus_Cor> obtenirTousLesProcessusCor() throws SQLException;
    void modifierProcessusCor(Processus_Cor processusCor) throws SQLException;
    void supprimerProcessusCor(int id) throws SQLException;
}
