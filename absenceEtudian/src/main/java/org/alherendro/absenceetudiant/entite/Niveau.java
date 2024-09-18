package org.alherendro.absenceetudiant.entite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Niveau {
    private int id;
    private String name;
    public Niveau() {
    }


    public Niveau(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
