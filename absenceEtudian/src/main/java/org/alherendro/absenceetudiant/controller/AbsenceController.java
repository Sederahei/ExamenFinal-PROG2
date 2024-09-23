/*package org.alherendro.absenceetudiant.controller;

import org.alherendro.absenceetudiant.entite.Absence;
import org.alherendro.absenceetudiant.service.AbsenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @PostMapping
    public ResponseEntity<String> ajouterAbsence(@RequestBody Absence absence) {
        if (absence.getDateAbsence() == null) {
            return ResponseEntity.badRequest().body(" LA date d'absence est obligatoire");
        }
        try {
            absenceService.ajouterAbsence(absence);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absence> obtenirAbsenceParId(@PathVariable int id) {
        try {
            Absence absence = absenceService.obtenirAbsenceParId(id);
            return absence != null ? ResponseEntity.ok(absence) : ResponseEntity.notFound().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Absence>> obtenirToutesLesAbsences() {
        try {
            List<Absence> absences = absenceService.obtenirToutesLesAbsences();
            return ResponseEntity.ok(absences);
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifierAbsence(@PathVariable int id, @RequestBody Absence absence) {
        absence.setId(id);
        try {
            absenceService.modifierAbsence(absence);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAbsence(@PathVariable int id) {
        try {
            absenceService.supprimerAbsence(id);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }
}*/

package org.alherendro.absenceetudiant.controller;

import org.alherendro.absenceetudiant.entite.Absence;
import org.alherendro.absenceetudiant.service.AbsenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    // Ajouter une nouvelle absence
    @PostMapping
    public ResponseEntity<Void> ajouterAbsence(@RequestBody Absence absence) {
        try {
            absenceService.ajouterAbsence(absence);
            return ResponseEntity.status(201).build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Absence> obtenirAbsenceParId(@PathVariable int id) {
        try {
            Absence absence = absenceService.obtenirAbsenceParId(id);
            return absence != null ? ResponseEntity.ok(absence) : ResponseEntity.notFound().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Absence>> obtenirToutesLesAbsences() {
        try {
            List<Absence> absences = absenceService.obtenirToutesLesAbsences();
            return ResponseEntity.ok(absences);
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> modifierAbsence(@PathVariable int id, @RequestBody Absence absence) {
        absence.setId(id);
        try {
            absenceService.modifierAbsence(absence);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAbsence(@PathVariable int id) {
        try {
            absenceService.supprimerAbsence(id);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }
}

