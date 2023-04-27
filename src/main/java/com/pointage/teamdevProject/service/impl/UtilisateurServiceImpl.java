package com.pointage.teamdevProject.service.impl;

import com.pointage.teamdevProject.Converter.UtilisateurConverter;
import com.pointage.teamdevProject.dao.DemandeUserRepository;
import com.pointage.teamdevProject.dao.PointageRepository;
import com.pointage.teamdevProject.dao.RoleRepository;
import com.pointage.teamdevProject.dao.UtilisateurRepository;
import com.pointage.teamdevProject.dto.GetPointageDto;
import com.pointage.teamdevProject.dto.GetUtilisateurDto;
import com.pointage.teamdevProject.dto.PointageDto;
import com.pointage.teamdevProject.dto.UtilisateurDto;
import com.pointage.teamdevProject.entites.DemandeUser;
import com.pointage.teamdevProject.entites.Pointage;
import com.pointage.teamdevProject.entites.Role;
import com.pointage.teamdevProject.entites.Utilisateur;
import com.pointage.teamdevProject.service.PointageService;
import com.pointage.teamdevProject.service.UtilisateurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private PointageRepository pointageRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DemandeUserRepository demandeUserRepository;
    @Autowired
    UtilisateurConverter utilisateurConverter;
    @Override
    public List<Utilisateur> GetAllUtilistaurs() {
        return utilisateurRepository.findAll();

    }
    @Override
    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    @Override
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        Optional<Utilisateur> existingUtilisateur = utilisateurRepository.findById(id);

        if (existingUtilisateur.isPresent()) {
            Utilisateur updatedUtilisateur = existingUtilisateur.get();
            updatedUtilisateur.setNom(utilisateur.getNom());
            updatedUtilisateur.setPrenom(utilisateur.getPrenom());
            updatedUtilisateur.setEmail(utilisateur.getEmail());


            updatedUtilisateur = new Utilisateur();
            return utilisateurRepository.save(updatedUtilisateur);
        } else {
            throw new EntityNotFoundException(" Utilisateur with id " + id + " not found");
        }
    }
    @Override
    public void deleteUtilisateur(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

        if (utilisateur.isPresent()) {
            utilisateurRepository.delete(utilisateur.get());
        } else {
            throw new EntityNotFoundException("Utilisateur with id " + id + " not found");
        }


    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        utilisateurRepository.deleteById(id);
    }
    @Override
    public GetUtilisateurDto save(UtilisateurDto utilisateurDto) {
        Role role = roleRepository.findById(utilisateurDto.getRole().getId()).get();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurDto.getNom());
        //pointage.setHeureSortie(pointageDto.getEndTime());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setDateNaiss(utilisateurDto.getDateNaiss());
        utilisateur.setImage(utilisateurDto.getImage());
        utilisateur.setRole(role);
        utilisateurRepository.save(utilisateur);
        GetUtilisateurDto getUtilisateurDto = utilisateurConverter.getentityToDto(utilisateur);
        return getUtilisateurDto;
    }

    @Override
    public Utilisateur findByEmail(String email) {
        return null;
    }

    @Override
    public HashMap<Object, Object> getPointageFromUtilisateur(Long id) {
        HashMap<Object, Object> hashMap=new HashMap<>();
        if(utilisateurRepository.existsById(id)){
        Utilisateur utilisateur=utilisateurRepository.findById(id).get();
        hashMap.put("id",utilisateur.getId());
        hashMap.put("pointages",utilisateur.getPointages());
            return hashMap;
        }else
        return null;
    }

    @Override
    public List<GetUtilisateurDto> getAllUtilisateur() {
        List<Utilisateur> utilisateurList=utilisateurRepository.findAll();
        List<GetUtilisateurDto>list=utilisateurConverter.getentityToDto(utilisateurList);
        return list;
    }



}
