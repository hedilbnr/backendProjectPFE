package com.pointage.teamdevProject.dao;

import com.pointage.teamdevProject.entites.Pointage;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointageRepository extends JpaRepository<Pointage,Long> {
    @Query(value = "SELECT * FROM pointage where utilisateur_id=:id",nativeQuery = true)
    List<Pointage>findAllByIdUtilisateur(@Param("id")Long id);

    @Query(value = "SELECT DATE(p.heure_pointage) as date,\n" +
            "       MIN(p.heure_pointage) as heure_entree\t,\n" +
            "       MAX(p.heure_pointage) as heure_sortie,\n" +
            "       u.nom, u.prenom, u.id\n" +
            "FROM pointage as p \n" +
            "join utilisateur as u\n" +
            "on p.utilisateur_id=u.id\n" +
            "GROUP BY DATE(p.heure_pointage)\n" +
            "having date = DATE(NOW()) ",nativeQuery = true)
    List<JSONObject>findMinMaxPointageByUtilisateur();

}
