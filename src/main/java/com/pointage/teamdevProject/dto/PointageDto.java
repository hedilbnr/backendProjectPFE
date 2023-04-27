package com.pointage.teamdevProject.dto;

import com.pointage.teamdevProject.entites.Utilisateur;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PointageDto {
    private Date date;
    private Date heurePointage;
    //private Date heureSortie;
    private Utilisateur utilisateur;

}
