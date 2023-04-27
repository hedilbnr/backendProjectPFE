package com.pointage.teamdevProject.service;

import com.pointage.teamdevProject.dto.DemandeUserDto;
import com.pointage.teamdevProject.entites.DemandeUser;

import java.util.List;
import java.util.Optional;

public interface DemandeUserService {
    DemandeUser createDemandeUser(DemandeUser demandeUser);

    Object updateDemandeUser(Long id, DemandeUserDto demandeUserDto);

    boolean deleteDemandeUser(Long id);

    Optional<DemandeUser> findById(Long id);

    List<DemandeUser> findAll();

    DemandeUser save(DemandeUserDto demandeUserDto);

    List<DemandeUser> getAllDemandeUsers();

    DemandeUser getDemandeUserById(Long id);

    void deleteById(Long id);
}
