package org.alherendro.absenceetudiant.controller;

import org.alherendro.absenceetudiant.entite.Processus_Cor;
import org.alherendro.absenceetudiant.service.ProcessusCorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/processusCor")
public class ProcessusCorController {
    private final ProcessusCorService processusCorService;

    public ProcessusCorController(ProcessusCorService processusCorService) {
        this.processusCorService = processusCorService;
    }

    @PostMapping
    public ResponseEntity<Void> ajouterProcessusCor(@RequestBody Processus_Cor processusCor) {
        try {
            processusCorService.ajouterProcessusCor(processusCor);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Processus_Cor> obtenirProcessusCorParId(@PathVariable int id) {
        try {
            Processus_Cor processusCor = processusCorService.obtenirProcessusCorParId(id);
            if (processusCor != null) {
                return ResponseEntity.ok(processusCor);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Processus_Cor>> obtenirTousLesProcessusCor() {
        try {
            List<Processus_Cor> processusCorList = processusCorService.obtenirTousLesProcessusCor();
            return ResponseEntity.ok(processusCorList);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifierProcessusCor(@PathVariable int id, @RequestBody Processus_Cor processusCor) {
        try {
            processusCor.setId(id);  // Set the ID for the update
            processusCorService.modifierProcessusCor(processusCor);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProcessusCor(@PathVariable int id) {
        try {
            processusCorService.supprimerProcessusCor(id);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
