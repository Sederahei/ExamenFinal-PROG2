package org.alherendro.absenceetudiant.entite;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class Justificatif {
    private int id;
    private Date dateJustificative;
    private String cours;
    private String statusJustificative;
    private int idAbsence;

    public Justificatif() {
    }

    public Justificatif(int id, Date dateJustificative, String cours, String statusJustificative, int idAbsence) {
        this.id = id;
        this.dateJustificative = dateJustificative;
        this.cours = cours;
        this.statusJustificative = statusJustificative;
        this.idAbsence = idAbsence;
    }


}
