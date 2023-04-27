package com.pointage.teamdevProject.dao;

import com.pointage.teamdevProject.entites.DemandeUser;
import com.pointage.teamdevProject.entites.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeUserRepository extends JpaRepository<DemandeUser,Long> {
}
