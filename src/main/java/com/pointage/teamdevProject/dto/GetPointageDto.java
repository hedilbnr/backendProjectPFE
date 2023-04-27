package com.pointage.teamdevProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class GetPointageDto {
    private Date date;
    private Date heurePointage;
    //private Date HeureSortie;
    private UtilisateurDto utilisateur;
}
