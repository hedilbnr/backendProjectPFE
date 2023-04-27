package com.pointage.teamdevProject.dto;


import com.pointage.teamdevProject.entites.DemandeConge;
import com.pointage.teamdevProject.entites.DemandeUser;
import com.pointage.teamdevProject.entites.Utilisateur;

import java.util.Date;

public abstract class DemandeCongeDto {
    private Date dateDebut;
    private Date dateFin;
    private String type;
    private boolean etat;
    private Utilisateur utilisateur ;




    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }



}
