package com.pointage.teamdevProject.service;

import com.pointage.teamdevProject.dto.GetUtilisateurDto;
import com.pointage.teamdevProject.dto.UtilisateurDto;
import com.pointage.teamdevProject.entites.Utilisateur;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public interface UtilisateurService {


    public List<Utilisateur> GetAllUtilistaurs();

    public Optional<Utilisateur> getUtilisateurById(Long id);



        public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur);

    public void deleteUtilisateur(Long id);


    List<Utilisateur> findAll();

    void delete(Long  idutilisateur);


    public  GetUtilisateurDto save(UtilisateurDto utilisateurDto);

    public Utilisateur findByEmail(String email);
    HashMap<Object,Object> getPointageFromUtilisateur(Long id);
    List<GetUtilisateurDto>getAllUtilisateur();

}

