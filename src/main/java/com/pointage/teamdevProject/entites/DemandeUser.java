package com.pointage.teamdevProject.entites;

import jakarta.persistence.*;

@Entity
public class DemandeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    boolean reponse;

    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private DemandeConge demandeConge;

    public DemandeUser(long id, boolean reponse, Utilisateur utilisateur, DemandeUser demandeUser) {
        this.id = id;
        this.reponse = reponse;
        this.utilisateur = utilisateur;
        this.demandeConge = demandeConge;
    }

    public DemandeUser() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setDemandeConge(DemandeConge demandeconge) {
        this.demandeConge = demandeConge;
    }

    public void setDemandeUser(DemandeUser demandeUser) {
    }

    public void setreponse(Object getreponse) {
    }
}
