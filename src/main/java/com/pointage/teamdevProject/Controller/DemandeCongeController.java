package com.pointage.teamdevProject.Controller;

import com.pointage.teamdevProject.dto.DemandeCongeDto;
import com.pointage.teamdevProject.dto.RoleDto;
import com.pointage.teamdevProject.entites.DemandeConge;
import com.pointage.teamdevProject.entites.Role;
import com.pointage.teamdevProject.entites.Utilisateur;
import com.pointage.teamdevProject.service.DemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandeconges")
public class DemandeCongeController {
    @Autowired
    private DemandeCongeService demandeCongeService;
    private Object DemandeCongeDto;

    @GetMapping("")
    public List<DemandeConge> getAllDemandeConge() {
        DemandeCongeController demandeCongeService = null;
        return demandeCongeService.getAllDemandeConges();
    }

    public List<DemandeConge> getAllDemandeConges() {
        return demandeCongeService.getAllDemandeConges();
    }

    @GetMapping("/{id}")
    public DemandeConge getDemandeCongeById(@PathVariable(value = "id") Long id) {
        return demandeCongeService.getDemandeCongeById(id);
    }

    @PostMapping("")
    public DemandeConge createDemandeConge(@RequestBody DemandeConge demandeConge) {
        return demandeCongeService.createDemandeConge(demandeConge);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandeConge> updateDemandeConge(@PathVariable Long id, @RequestBody DemandeCongeDto demandeCongeDto){
        boolean updated = demandeCongeService.updateDemandeConge(id, demandeCongeDto);
        if (updated) {
            DemandeConge demandeConge = demandeCongeService.getDemandeCongeById(id);
            return ResponseEntity.ok(demandeConge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDemandeConge(@PathVariable(value = "id") Long id) {
        if(demandeCongeService.deleteDemandeConge(id)==true)
            return ResponseEntity.ok().body("DemandeConge deleted");
        else
            return ResponseEntity.status(400).body("id not found");

    }
}