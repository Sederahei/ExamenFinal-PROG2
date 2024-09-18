package org.alherendro.absenceetudiant.entite;

import lombok.Getter;
import lombok.Setter;
import org.alherendro.absenceetudiant.model.StatusEtudiant;

@Setter
@Getter




    public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String adress;
    private String std;
    private StatusEtudiant status;

    public Etudiant(int id, String nom, String prenom, String email, String adress, String std, String status) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adress = adress;
        this.std = std;
        this.status = StatusEtudiant.valueOf(status);
    }

    public Etudiant() {

    }

    public String getAdresse() {
        return null;
    }

    public String getStd() {
        return null;
    }


}

