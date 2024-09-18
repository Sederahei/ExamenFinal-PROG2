package org.alherendro.absenceetudiant.entite;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class Absence {
    private int id;
    private Date dateAbsence;
    private String cours;
    private int idEtudiant;

    public Absence() {
    }

    public Absence(int id, Date dateAbsence, String cours, int idEtudiant) {
        this.id = id;
        this.dateAbsence = dateAbsence;
        this.cours = cours;
        this.idEtudiant = idEtudiant;
    }

}
