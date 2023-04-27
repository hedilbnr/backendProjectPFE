package com.pointage.teamdevProject.service;

import com.pointage.teamdevProject.dto.GetPointageDto;
import com.pointage.teamdevProject.dto.PointageDto;
import com.pointage.teamdevProject.entites.Pointage;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.List;
import java.util.Optional;

public interface PointageService {
    GetPointageDto save(PointageDto pointageDto);

    Optional<Pointage> findById(Long id);

    List<Pointage> findAll();

    void deleteById(Long id);

    void updateEndTime(Long id, String endTime);
    List<GetPointageDto> getListPointageByIdUtilisateur(Long id);
    List<JSONObject> getbymaxminPointageByUtilisateur();

}
