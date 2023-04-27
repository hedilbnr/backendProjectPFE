package com.pointage.teamdevProject.service.impl;

import com.pointage.teamdevProject.Converter.PointageConverter;
import com.pointage.teamdevProject.dao.PointageRepository;
import com.pointage.teamdevProject.dao.UtilisateurRepository;
import com.pointage.teamdevProject.dto.GetPointageDto;
import com.pointage.teamdevProject.dto.PointageDto;
import com.pointage.teamdevProject.entites.Pointage;
import com.pointage.teamdevProject.entites.Utilisateur;
import com.pointage.teamdevProject.service.PointageService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class PointageServiceImpl<JavaIOFileDescriptorAccess> implements PointageService {
    @Autowired
    private PointageRepository pointageRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    PointageConverter pointageConverter;
    @Override

    public GetPointageDto save(PointageDto pointageDto) {
        Utilisateur utilisateur=utilisateurRepository.findById(pointageDto.getUtilisateur().getId()).get();
        Pointage pointage=new Pointage();
        pointage.setHeurePointage(pointageDto.getHeurePointage());
        //pointage.setHeureSortie(pointageDto.getEndTime());
        pointage.setDate(pointageDto.getDate());
        pointage.setUtilisateur(utilisateur);
         pointageRepository.save(pointage);
         GetPointageDto getPointageDto= pointageConverter.entityToDto(pointage);
         return getPointageDto;
    }
    @Override
    public Optional<Pointage> findById(Long id) {
        return pointageRepository.findById(id);
    }
    @Override
    public List<Pointage> findAll() {
        return pointageRepository.findAll();
    }
    @Override
    public void deleteById(Long id) {
        pointageRepository.deleteById(id);
    }


    @Override
    public void updateEndTime(Long id, String endTime) {

    }

    @Override
    public List<GetPointageDto> getListPointageByIdUtilisateur(Long id) {
        List<Pointage> list=pointageRepository.findAllByIdUtilisateur(id);
        List<GetPointageDto> dtoList=pointageConverter.entityToDto(list);
        return dtoList;
    }

    @Override
    public List<JSONObject> getbymaxminPointageByUtilisateur() {
           return pointageRepository.findMinMaxPointageByUtilisateur();
    }


}

