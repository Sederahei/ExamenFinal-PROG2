package org.alherendro.absenceetudiant.controller;

import org.alherendro.absenceetudiant.entite.Etudiant;
import org.alherendro.absenceetudiant.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // Récupérer tous les étudiants
    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        try {
            List<Etudiant> etudiants = etudiantService.obtenirTousLesEtudiants();
            return new ResponseEntity<>(etudiants, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Récupérer un étudiant par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable int id) {
        try {
            Etudiant etudiant = etudiantService.obtenirEtudiantParId(id);
            if (etudiant != null) {
                return new ResponseEntity<>(etudiant, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Ajouter un nouvel étudiant
    @PostMapping
    public ResponseEntity<String> ajouterEtudiant(@RequestBody Etudiant etudiant) {
        try {
            etudiantService.ajouterEtudiant(etudiant);
            return new ResponseEntity<>("Étudiant ajouté avec succès", HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>("Erreur lors de l'ajout de l'étudiant", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Modifier un étudiant existant
    @PutMapping("/{id}")
    public ResponseEntity<String> modifierEtudiant(@PathVariable int id, @RequestBody Etudiant etudiant) {
        try {
            etudiant.setId(id);
            etudiantService.modifierEtudiant(etudiant);
            return new ResponseEntity<>("Étudiant modifié avec succès", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Erreur lors de la modification de l'étudiant", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Supprimer un étudiant
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerEtudiant(@PathVariable int id) {
        try {
            etudiantService.supprimerEtudiant(id);
            return new ResponseEntity<>("Étudiant supprimé avec succès", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Erreur lors de la suppression de l'étudiant", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
