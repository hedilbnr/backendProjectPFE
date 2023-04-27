package com.pointage.teamdevProject.dto;

import com.pointage.teamdevProject.entites.DemandeUser;
import com.pointage.teamdevProject.entites.Pointage;
import com.pointage.teamdevProject.entites.Role;

import java.util.Date;

public class UtilisateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private Date dateNaiss;
    private String image ;
    private Role role;
    private Pointage pointage;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pointage getPointage() {
        return pointage;
    }

    public void setPointage(Pointage pointage) {
        this.pointage = pointage;
    }

}
