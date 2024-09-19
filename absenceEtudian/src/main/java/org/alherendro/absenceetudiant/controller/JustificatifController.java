package org.alherendro.absenceetudiant.controller;

import org.alherendro.absenceetudiant.entite.Justificatif;
import org.alherendro.absenceetudiant.service.JustificatifService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/justificatifs")
public class JustificatifController {

    private final JustificatifService justificatifService;

    public JustificatifController(JustificatifService justificatifService) {
        this.justificatifService = justificatifService;
    }

    @PostMapping
    public ResponseEntity<Void> ajouterJustificatif(@RequestBody Justificatif justificatif) {
        try {
            justificatifService.ajouterJustificatif(justificatif);
            return ResponseEntity.status(201).build(); // Created
        } catch (SQLException e) {
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Justificatif> obtenirJustificatif(@PathVariable int id) {
        try {
            Justificatif justificatif = justificatifService.obtenirJustificatifParId(id);
            return justificatif != null ? ResponseEntity.ok(justificatif) : ResponseEntity.notFound().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    @GetMapping
    public ResponseEntity<List<Justificatif>> obtenirTousLesJustificatifs() {
        try {
            List<Justificatif> justificatifs = justificatifService.obtenirTousLesJustificatifs();
            return ResponseEntity.ok(justificatifs);
        } catch (SQLException e) {
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifierJustificatif(@PathVariable int id, @RequestBody Justificatif justificatif) {
        justificatif.setId(id); // Set the ID from the path variable
        try {
            justificatifService.modifierJustificatif(justificatif);
            return ResponseEntity.ok().build(); // OK
        } catch (SQLException e) {
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerJustificatif(@PathVariable int id) {
        try {
            justificatifService.supprimerJustificatif(id);
            return ResponseEntity.noContent().build(); // No Content
        } catch (SQLException e) {
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }
}
