package com.pointage.teamdevProject.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@Entity
public class Pointage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private  Date date;
    private Date heurePointage ;
 //   private Date heureSortie;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonBackReference
    private Utilisateur utilisateur;

    public Pointage() {
    }

    public Pointage(Long id, Date date, Date heurePointage, Utilisateur utilisateur) {
        this.id = id;
        this.date = date;
        heurePointage = heurePointage;
      //  heureSortie = heureSortie;
        this.utilisateur = utilisateur;
    }
}
