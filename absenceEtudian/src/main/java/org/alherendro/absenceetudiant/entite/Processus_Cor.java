package org.alherendro.absenceetudiant.entite;

import java.util.Date;

public class Processus_Cor {
    private int id;
    private Date dateDebut;
    private String status;
    private int idEtudiant;

    public Processus_Cor() {
    }

    public Processus_Cor(int id, Date dateDebut, String status, int idEtudiant) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.status = status;
        this.idEtudiant = idEtudiant;
    }


}
