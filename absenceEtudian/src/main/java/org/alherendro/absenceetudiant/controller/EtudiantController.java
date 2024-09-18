package org.alherendro.absenceetudiant.controller;
import org.alherendro.absenceetudiant.entite.Etudiant;
import org.alherendro.absenceetudiant.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
/*
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() throws SQLException {
        return new ResponseEntity<>(etudiantService.getAllEtudiants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable int id) throws SQLException {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createEtudiant(@RequestBody Etudiant etudiant) throws SQLException {
        etudiantService.createEtudiant(etudiant);
        return new ResponseEntity<>("Etudiant créé avec succès", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEtudiant(@PathVariable int id, @RequestBody Etudiant etudiant) throws SQLException {
        etudiant.setId(id);
        etudiantService.updateEtudiant(etudiant);
        return new ResponseEntity<>("Etudiant mis à jour avec succès", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable int id) throws SQLException {
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>("Etudiant supprimé avec succès", HttpStatus.OK);
    }
}*/
@RestController
public class EtudiantController {

    private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService){
        this.etudiantService = etudiantService;
    }

    @GetMapping("/etudiant/{id}")
    public ResponseEntity<Etudiant> obtenirEtudiant(@PathVariable int id) throws SQLException {
        Etudiant etudiant = etudiantService.obtenirEtudiantParId(id);
        return etudiant != null ? ResponseEntity.ok(etudiant) : ResponseEntity.notFound().build();
    }

    @GetMapping("/etudiant")
    public List<Etudiant> obtenirTousLesEtudiants() throws SQLException {
        List<Etudiant> etudiants = etudiantService.obtenirTousLesEtudiants();
        System.out.println(etudiants);
        return etudiants;
    }

    @PostMapping("/etudiant")
    public ResponseEntity<String> creerEtudiant(@RequestBody Etudiant etudiant) throws SQLException {
        etudiantService.modifierEtudiant(etudiant);  // Assuming you're using this to save a new student
        return ResponseEntity.ok("Étudiant créé avec succès");
    }

    @PutMapping("/etudiant/{id}")
    public ResponseEntity<String> modifierEtudiant(@PathVariable int id, @RequestBody Etudiant etudiant) throws SQLException {
        etudiant.setId(id);
        etudiantService.modifierEtudiant(etudiant);
        return ResponseEntity.ok("Étudiant modifié avec succès");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerEtudiant(@PathVariable int id) throws SQLException {
        etudiantService.supprimerEtudiant(id);
        return ResponseEntity.ok("Étudiant supprimé avec succès");
    }
}
