package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.entite.Absence;
import org.alherendro.absenceetudiant.repository.AbsenceRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AbsenceService {

    private final AbsenceRepository absenceRepository;

    public AbsenceService(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public void ajouterAbsence(Absence absence) throws SQLException {
        absenceRepository.ajouterAbsence(absence);
    }

    public Absence obtenirAbsenceParId(int id) throws SQLException {
        return absenceRepository.obtenirAbsenceParId(id);
    }

    public List<Absence> obtenirToutesLesAbsences() throws SQLException {
        return absenceRepository.obtenirToutesLesAbsences();
    }

    public void modifierAbsence(Absence absence) throws SQLException {
        absenceRepository.modifierAbsence(absence);
    }

    public void supprimerAbsence(int id) throws SQLException {
        absenceRepository.supprimerAbsence(id);
    }
}
