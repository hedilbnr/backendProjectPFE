package com.pointage.teamdevProject.entites;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    @OneToMany(mappedBy = "role")
    private List<Utilisateur> utilisateur;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Utilisateur> getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(List<Utilisateur> utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role() {
    }
}
