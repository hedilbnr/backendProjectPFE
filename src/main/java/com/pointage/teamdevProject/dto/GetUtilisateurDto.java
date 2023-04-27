package com.pointage.teamdevProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter

public class GetUtilisateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private Date dateNaiss;
    private String image ;
    private List <GetPointageDto> pointages;
//    private PointageDto pointage ;

}
