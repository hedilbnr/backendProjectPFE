package com.pointage.teamdevProject.dao;

import com.pointage.teamdevProject.entites.Role;
import com.pointage.teamdevProject.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
