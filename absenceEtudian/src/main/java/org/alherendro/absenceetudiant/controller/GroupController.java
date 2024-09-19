package org.alherendro.absenceetudiant.controller;

import org.alherendro.absenceetudiant.entite.Group;
import org.alherendro.absenceetudiant.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/groupes")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    // Endpoint to create a new group
    @PostMapping
    public ResponseEntity<String> ajouterGroup(@RequestBody Group group) {
        try {
            groupService.ajouterGroup(group);
            return ResponseEntity.status(HttpStatus.CREATED).body("Groupe ajouté avec succès.");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du groupe.");
        }
    }

    // Endpoint to get a group by ID
    @GetMapping("/{id}")
    public ResponseEntity<Group> obtenirGroupParId(@PathVariable int id) {
        try {
            Group group = groupService.obtenirGroupParId(id);
            if (group != null) {
                return ResponseEntity.ok(group);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint to get all groups
    @GetMapping
    public ResponseEntity<List<Group>> obtenirTousLesGroupes() {
        try {
            List<Group> groupes = groupService.obtenirTousLesGroupes();
            return ResponseEntity.ok(groupes);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint to update a group by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> modifierGroup(@PathVariable int id, @RequestBody Group group) {
        try {
            group.setId(id);
            groupService.modifierGroup(group);
            return ResponseEntity.ok("Groupe modifié avec succès.");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la modification du groupe.");
        }
    }

    // Endpoint to delete a group by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerGroup(@PathVariable int id) {
        try {
            groupService.supprimerGroup(id);
            return ResponseEntity.ok("Groupe supprimé avec succès.");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression du groupe.");
        }
    }
}
