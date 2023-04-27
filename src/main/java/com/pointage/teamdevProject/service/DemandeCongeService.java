package com.pointage.teamdevProject.service;

import com.pointage.teamdevProject.dto.DemandeCongeDto;
import com.pointage.teamdevProject.entites.DemandeConge;
import com.pointage.teamdevProject.entites.Role;

import java.util.List;
import java.util.Optional;

public interface DemandeCongeService {
    DemandeConge getDemandeCongeById(Long id);

    Role createDemandeConge(Role role);

    DemandeConge createDemandeConge(DemandeConge demandeConge);

    boolean updateDemandeConge(Long id, DemandeCongeDto demandeCongeDto);

    boolean deleteDemandeConge(Long id);

    DemandeConge save(DemandeCongeDto demandeCongeDto);

    Optional<DemandeConge> findById(Long id);

    List<DemandeConge> findAll();

    void deleteById(Long id);

    void updateEndTime(Long id, String endTime);

    List<DemandeConge> getAllDemandeConges();
}
