package org.alherendro.absenceetudiant.service;

import org.alherendro.absenceetudiant.entite.Group;
import org.alherendro.absenceetudiant.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    // Method to add a new Group
    public void ajouterGroup(Group group) throws SQLException {
        groupRepository.ajouterGroup(group);
    }

    // Method to get a Group by ID
    public Group obtenirGroupParId(int id) throws SQLException {
        return groupRepository.obtenirGroupParId(id);
    }

    // Method to get all Groups
    public List<Group> obtenirTousLesGroupes() throws SQLException {
        return groupRepository.obtenirTousLesGroupes();
    }

    // Method to update a Group
    public void modifierGroup(Group group) throws SQLException {
        groupRepository.modifierGroup(group);
    }

    // Method to delete a Group by ID
    public void supprimerGroup(int id) throws SQLException {
        groupRepository.supprimerGroup(id);
    }
}
