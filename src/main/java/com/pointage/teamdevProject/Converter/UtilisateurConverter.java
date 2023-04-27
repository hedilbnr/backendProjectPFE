package com.pointage.teamdevProject.Converter;

import com.pointage.teamdevProject.dto.GetPointageDto;
import com.pointage.teamdevProject.dto.GetUtilisateurDto;
import com.pointage.teamdevProject.dto.UtilisateurDto;
import com.pointage.teamdevProject.entites.Pointage;
import com.pointage.teamdevProject.entites.Utilisateur;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UtilisateurConverter {

    public UtilisateurDto entityToDto(Utilisateur utilisateur){
        UtilisateurDto user=new UtilisateurDto();
        user.setEmail(utilisateur.getEmail());
        user.setDateNaiss(utilisateur.getDateNaiss());
        user.setNom(utilisateur.getNom());
        user.setPrenom(utilisateur.getPrenom());
        user.setImage(utilisateur.getImage());
        user.setId(utilisateur.getId());
        return user;

    }
    public GetUtilisateurDto getentityToDto(Utilisateur utilisateur){
        GetUtilisateurDto user=new GetUtilisateurDto();
        user.setEmail(utilisateur.getEmail());
        user.setDateNaiss(utilisateur.getDateNaiss());
        user.setNom(utilisateur.getNom());
        user.setPrenom(utilisateur.getPrenom());
        user.setImage(utilisateur.getImage());
        user.setId(utilisateur.getId());
        return user;
    }
    public List<GetUtilisateurDto> getentityToDto(List<Utilisateur> utilisateurs ) {
        return	utilisateurs.stream().map(x -> getentityToDto(x)).collect(Collectors.toList());
    }
}
