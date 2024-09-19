package org.alherendro.absenceetudiant.controller;

import org.alherendro.absenceetudiant.entite.Niveau;
import org.alherendro.absenceetudiant.service.NiveauService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/niveaux")
public class NiveauController {
    private final NiveauService niveauService;

    public NiveauController(NiveauService niveauService) {
        this.niveauService = niveauService;
    }

    @PostMapping
    public ResponseEntity<Void> ajouterNiveau(@RequestBody Niveau niveau) {
        try {
            niveauService.ajouterNiveau(niveau);
            return ResponseEntity.status(201).build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Niveau> obtenirNiveau(@PathVariable int id) {
        try {
            Niveau niveau = niveauService.obtenirNiveauParId(id);
            return niveau != null ? ResponseEntity.ok(niveau) : ResponseEntity.notFound().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Niveau>> obtenirTousLesNiveaux() {
        try {
            List<Niveau> niveaux = niveauService.obtenirTousLesNiveaux();
            return ResponseEntity.ok(niveaux);
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifierNiveau(@PathVariable int id, @RequestBody Niveau niveau) {
        try {
            niveau.setId(id);
            niveauService.modifierNiveau(niveau);
            return ResponseEntity.noContent().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerNiveau(@PathVariable int id) {
        try {
            niveauService.supprimerNiveau(id);
            return ResponseEntity.noContent().build();
        } catch (SQLException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
