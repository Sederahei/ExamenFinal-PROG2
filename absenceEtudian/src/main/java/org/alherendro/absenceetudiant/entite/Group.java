package org.alherendro.absenceetudiant.entite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Group {
    private int id;
    private String nom;

    public Group() {
    }

    public Group(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }


}
