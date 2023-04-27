package com.pointage.teamdevProject.Converter;

import com.pointage.teamdevProject.dto.GetPointageDto;
import com.pointage.teamdevProject.entites.Pointage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PointageConverter {
    @Autowired
    UtilisateurConverter utilisateurConverter;
    public GetPointageDto entityToDto(Pointage pointage){
        GetPointageDto getPointageDto=new GetPointageDto();
        getPointageDto.setDate(pointage.getDate());
        getPointageDto.setHeurePointage(pointage.getHeurePointage());
        //getPointageDto.setHeureSortie(pointage.getHeureSortie());
        getPointageDto.setUtilisateur(utilisateurConverter.entityToDto(pointage.getUtilisateur()));
        return getPointageDto;
    }
    public List< GetPointageDto> entityToDto(List<Pointage> pointages ) {
        return	pointages.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
}
