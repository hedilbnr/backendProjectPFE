package com.pointage.teamdevProject.Controller;

import com.pointage.teamdevProject.dto.GetPointageDto;
import com.pointage.teamdevProject.dto.PointageDto;
import com.pointage.teamdevProject.entites.Pointage;
import com.pointage.teamdevProject.service.PointageService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/pointage")
public class PointageController {
        @Autowired
        private PointageService pointageService;





    @PostMapping("")
    public GetPointageDto createPointage(@RequestBody PointageDto pointageDto) {
            return pointageService.save(pointageDto);
        }
        //    @PostMapping("/utilisateurs")
//    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
//        return utilisateurService.save(utilisateur);
//    }
        @GetMapping("/{id}")
        public ResponseEntity<Pointage> findById(@PathVariable Long id) {
            Optional<Pointage> optionalPointage = pointageService.findById(id);
            if (optionalPointage.isPresent()) {
                return ResponseEntity.ok(optionalPointage.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @GetMapping("/ByUtilisateur/{id}")
    public ResponseEntity<?> findByUtilisateurId(@PathVariable Long id) {
        List<GetPointageDto> listPointage = pointageService.getListPointageByIdUtilisateur(id);
        if (listPointage!=null) {
            return ResponseEntity.status(200).body(listPointage);
        } else {
            return ResponseEntity.status(200).body(new ArrayList<>());
        }
    }

        @GetMapping("")
        public List<Pointage> findAll() {
            return pointageService.findAll();
        }

        @GetMapping("/today")
        public List<JSONObject> getbymaxminPointageByUtilisateur(){
        return pointageService.getbymaxminPointageByUtilisateur();
    }

        @DeleteMapping("/{id}")
        public void deleteById(@PathVariable Long id) {
            pointageService.deleteById(id);
        }

        @PutMapping("/{id}/end-time")
        public void updateEndTime(@PathVariable Long id, @RequestParam String endTime) {
            pointageService.updateEndTime(id, endTime);
        }
    }

