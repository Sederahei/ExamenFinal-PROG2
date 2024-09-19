package org.alherendro.absenceetudiant.controller;

import org.alherendro.absenceetudiant.entite.Status_etudiant;
import org.alherendro.absenceetudiant.service.StatusEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/status-etudiants")
public class StatusEtudiantController {

    private final StatusEtudiantService statusEtudiantService;

    @Autowired
    public StatusEtudiantController(StatusEtudiantService statusEtudiantService) {
        this.statusEtudiantService = statusEtudiantService;
    }

    @PostMapping
    public ResponseEntity<String> ajouterStatusEtudiant(@RequestBody Status_etudiant statusEtudiant) {
        try {
            statusEtudiantService.ajouterStatusEtudiant(statusEtudiant);
            return ResponseEntity.ok("Status étudiant ajouté avec succès.");
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Erreur lors de l'ajout du status étudiant: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status_etudiant> obtenirStatusEtudiantParId(@PathVariable int id) {
        try {
            Status_etudiant statusEtudiant = statusEtudiantService.obtenirStatusEtudiantParId(id);
            if (statusEtudiant != null) {
                return ResponseEntity.ok(statusEtudiant);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Status_etudiant>> obtenirTousLesStatusEtudiants() {
        try {
            List<Status_etudiant> statusEtudiants = statusEtudiantService.obtenirTousLesStatusEtudiants();
            return ResponseEntity.ok(statusEtudiants);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modifierStatusEtudiant(@PathVariable int id, @RequestBody Status_etudiant statusEtudiant) {
        try {
            statusEtudiant.setId(id);
            statusEtudiantService.modifierStatusEtudiant(statusEtudiant);
            return ResponseEntity.ok("Status étudiant modifié avec succès.");
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Erreur lors de la modification du status étudiant: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerStatusEtudiant(@PathVariable int id) {
        try {
            statusEtudiantService.supprimerStatusEtudiant(id);
            return ResponseEntity.ok("Status étudiant supprimé avec succès.");
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Erreur lors de la suppression du status étudiant: " + e.getMessage());
        }
    }
}

