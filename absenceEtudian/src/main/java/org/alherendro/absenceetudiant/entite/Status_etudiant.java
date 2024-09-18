package org.alherendro.absenceetudiant.entite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Status_etudiant {
    private int id;
    private String status;

    public Status_etudiant() {
    }

    public Status_etudiant(int id, String status) {
        this.id = id;
        this.status = status;
    }

}
