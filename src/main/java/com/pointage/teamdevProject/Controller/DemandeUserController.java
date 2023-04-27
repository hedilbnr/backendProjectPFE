package com.pointage.teamdevProject.Controller;

import com.pointage.teamdevProject.dto.DemandeUserDto;
import com.pointage.teamdevProject.entites.DemandeUser;
import com.pointage.teamdevProject.service.DemandeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandeUser")
public class DemandeUserController {
    @Autowired
    private DemandeUserService demandeUserService;

    @GetMapping("")
    public List<DemandeUser> getAllDemandeUsers() {
        return demandeUserService.getAllDemandeUsers();
    }

    @GetMapping("/{id}")
    public DemandeUser getDemandeUserById(@PathVariable(value = "id") Long id) {
        return demandeUserService.getDemandeUserById(id);
    }

    @PostMapping("")
    public DemandeUser createDemandeUser(@RequestBody DemandeUser demandeUser) {
        return demandeUserService.createDemandeUser(demandeUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandeUser> updateDemandeUser(@PathVariable Long id, @RequestBody DemandeUserDto demandeUserDto){
        boolean updated = (boolean) demandeUserService.updateDemandeUser(id, demandeUserDto);
        if (updated) {
            DemandeUser demandeUser = demandeUserService.getDemandeUserById(id);
            return ResponseEntity.ok(demandeUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDemandeUser(@PathVariable(value = "id") Long id) {
        if(demandeUserService.deleteDemandeUser(id)==true)
            return ResponseEntity.ok().body("DemandeUser deleted");
        else
            return ResponseEntity.status(400).body("id not found");

    }
}