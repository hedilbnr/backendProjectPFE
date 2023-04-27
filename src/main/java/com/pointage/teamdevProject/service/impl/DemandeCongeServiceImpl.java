package com.pointage.teamdevProject.service.impl;

import com.pointage.teamdevProject.dao.DemandeCongeRepository;
import com.pointage.teamdevProject.dao.DemandeUserRepository;
import com.pointage.teamdevProject.dto.DemandeCongeDto;
import com.pointage.teamdevProject.entites.DemandeConge;
import com.pointage.teamdevProject.entites.DemandeUser;
import com.pointage.teamdevProject.entites.Role;
import com.pointage.teamdevProject.service.DemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class DemandeCongeServiceImpl implements DemandeCongeService {

    @Autowired
    DemandeCongeRepository demandeCongeRepository;
    @Autowired
    DemandeUserRepository demandeUserRepository;
    public DemandeConge save(DemandeCongeDto demandeCongeDto) {
//        DemandeUser demandeUser = demandeUserRepository.findById(demandeCongeDto.getDemandeUser().getId())
//                .orElseThrow(() -> new ResourceNotFoundException("demandeUser not found"));
        DemandeConge demandeConge = new DemandeConge();
        demandeConge.setDateDebut(demandeCongeDto.getDateDebut());
        demandeConge.setDateFin(demandeCongeDto.getDateFin());
        demandeConge.setType(demandeCongeDto.getType());
        demandeConge.setEtat(demandeCongeDto.isEtat());
        return demandeCongeRepository.save(demandeConge);
    }


    public List<DemandeConge> getAllDemandeConges() {
     return (List<DemandeConge>) demandeCongeRepository.findAll();
 }

     public DemandeConge getDemandeCongeById(Long id) {
     return demandeCongeRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("role not found - " + id));
 }

    @Override
    public Role createDemandeConge(Role role) {
        return null;
    }


    @Override
    public DemandeConge createDemandeConge(DemandeConge demandeConge) {
        return demandeCongeRepository.save(demandeConge);


    }

    @Override
    public boolean updateDemandeConge(Long id, DemandeCongeDto demandeCongeDto) {
        Optional<DemandeConge> optionalDemandeConge = demandeCongeRepository.findById(id);
        if (optionalDemandeConge.isPresent()) {
            DemandeConge demandeConge = optionalDemandeConge.get();
            demandeConge.setDateDebut(demandeCongeDto.getDateDebut());
            demandeConge.setDateFin(demandeCongeDto.getDateFin());
            demandeConge.setType(demandeCongeDto.getType());
            demandeConge.setEtat(demandeCongeDto.isEtat());
            demandeCongeRepository.save(demandeConge);
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteDemandeConge(Long id) {
        return false;
    }




    @Override
    public Optional<DemandeConge> findById(Long id) {
        return demandeCongeRepository.findById(id);
    }
    @Override
    public List<DemandeConge> findAll() {
        return demandeCongeRepository.findAll();
    }
    @Override
    public void deleteById(Long id) {
        demandeCongeRepository.deleteById(id);
    }


    @Override
    public void updateEndTime(Long id, String endTime) {

    }
}

