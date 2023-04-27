package com.pointage.teamdevProject.service.impl;

import com.pointage.teamdevProject.dao.DemandeCongeRepository;
import com.pointage.teamdevProject.dao.DemandeUserRepository;
import com.pointage.teamdevProject.dto.DemandeUserDto;
import com.pointage.teamdevProject.entites.DemandeConge;
import com.pointage.teamdevProject.entites.DemandeUser;
import com.pointage.teamdevProject.service.DemandeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeUserServiceImpl implements DemandeUserService {

    @Autowired
    DemandeCongeRepository demandeCongeRepository;

    @Autowired
    DemandeUserRepository demandeUserRepository;

    @Override
    public DemandeUser save(DemandeUserDto demandeUserDto) {
        DemandeConge demandeConge = demandeCongeRepository.findById(demandeUserDto.getDemandeConge().getId())
                .orElseThrow(() -> new ResourceNotFoundException("DemandeConge not found"));

        DemandeUser demandeUser = new DemandeUser();
        demandeUser.setReponse(demandeUserDto.getReponse());
        demandeUser.setDemandeConge(demandeConge);

        return demandeUserRepository.save(demandeUser);
    }

    @Override
    public List<DemandeUser> getAllDemandeUsers() {
        return demandeUserRepository.findAll();
    }

    @Override
    public DemandeUser getDemandeUserById(Long id) {
        return null;
    }

    @Override
    public DemandeUser createDemandeUser(DemandeUser demandeUser) {
        return demandeUserRepository.save(demandeUser);
    }

    @Override
    public Object updateDemandeUser(Long id, DemandeUserDto demandeUserDto) {
        Optional<DemandeUser> optionalDemandeUser = demandeUserRepository.findById(id);
        if (optionalDemandeUser.isPresent()) {
            DemandeUser demandeUser = optionalDemandeUser.get();
            demandeUser.setReponse(demandeUserDto.getReponse());

            demandeUserRepository.save(demandeUser);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteDemandeUser(Long id) {
        return false;
    }

    @Override
    public Optional<DemandeUser> findById(Long id) {
        return demandeUserRepository.findById(id);
    }

    @Override
    public List<DemandeUser> findAll() {
        return demandeUserRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        demandeUserRepository.deleteById(id);
    }
}
