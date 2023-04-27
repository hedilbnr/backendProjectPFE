package com.pointage.teamdevProject.dao;

import com.pointage.teamdevProject.entites.DemandeConge;
import com.pointage.teamdevProject.entites.DemandeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeCongeRepository  extends JpaRepository<DemandeConge,Long> {
}
