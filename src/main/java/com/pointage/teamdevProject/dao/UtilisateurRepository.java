package com.pointage.teamdevProject.dao;

import com.pointage.teamdevProject.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository  extends JpaRepository<Utilisateur,Long> {
     Utilisateur findByEmail(String email);
}
