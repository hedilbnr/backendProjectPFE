package com.pointage.teamdevProject.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.sql.ast.tree.expression.Collation;

import java.awt.*;
import java.util.Collection;
import java.util.Date;
@Getter
@Setter
@Entity
public class DemandeConge {
    @Id
    private Long id ;
    private Date dateDebut;
    private Date dateFin;
    private String type;
    private boolean etat;
    @ManyToOne
    @JsonIgnore
    private Utilisateur utilisateur ;
    @OneToMany
    private Collection<DemandeUser> demandeUser;

    public DemandeConge() {

    }

    public DemandeConge(Long id, Date dateDebut, Date dateFin, String type, boolean etat) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.etat = etat;
    }


}
