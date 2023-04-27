package com.pointage.teamdevProject.entites;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Table
@Entity
@Data
@NoArgsConstructor
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private Date dateNaiss;
    private String image ;
    @OneToMany(mappedBy ="utilisateur" )
    @JsonManagedReference
    private List<Pointage> pointages ;
    @OneToMany(mappedBy = "utilisateur")
    private List<DemandeConge> demandeConges;
    @ManyToOne
    private Role role ;
    @OneToMany
    private List<DemandeUser> demandeUsers;


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPointages(List<Pointage> pointages) {
        this.pointages = pointages;
    }

    public void setDemandeConges(List<DemandeConge> demandeConges) {
        this.demandeConges = demandeConges;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setDemandeUser(List<DemandeUser> demandeUsers) {
        this.demandeUsers = demandeUsers;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public String getImage() {
        return image;
    }

    public List<Pointage> getPointages() {
        return pointages;
    }

    public List<DemandeConge> getDemandeConges() {
        return demandeConges;
    }

    public Role getRole() {
        return role;
    }

    public List<DemandeUser> getDemandeUsers() {
        return demandeUsers;
    }

    public Utilisateur(Long id, String nom, String prenom, String email, String motDePasse, Date dateNaiss, String image, List<Pointage> pointages, List<DemandeConge> demandeConges, Role role, List<DemandeUser> demandeUsers) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaiss = dateNaiss;
        this.image = image;
        this.pointages = pointages;
        this.demandeConges = demandeConges;
        this.role = role;
        this.demandeUsers = demandeUsers;
    }

    public void setPointage(Pointage pointage) {
    }
}
