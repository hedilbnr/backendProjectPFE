package com.pointage.teamdevProject.dto;

import com.pointage.teamdevProject.entites.DemandeConge;
import com.pointage.teamdevProject.entites.Utilisateur;

public abstract class DemandeUserDto {
    boolean reponse;
    private Utilisateur utilisateur;
    private DemandeConge demandeConge;

    public boolean isReponse() {
        return reponse;
    }

    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public DemandeConge getDemandeConge() {
        return demandeConge;
    }

    public void setDemandeConge(DemandeConge demandeConge) {
        this.demandeConge = demandeConge;
    }

    public abstract Object getreponse() ;

    public abstract boolean getReponse();
}
