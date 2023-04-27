package com.pointage.teamdevProject.Controller;

import com.pointage.teamdevProject.dao.UtilisateurRepository;
import com.pointage.teamdevProject.dto.GetUtilisateurDto;
import com.pointage.teamdevProject.dto.UtilisateurDto;
import com.pointage.teamdevProject.entites.Utilisateur;
import com.pointage.teamdevProject.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("utilisateurs")
@Controller
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    //get user
//    @GetMapping("")
//    public List<Utilisateur> getAllUtilisateur(){
//        return utilisateurService.findAll();
//    }
    @PostMapping("")
    public ResponseEntity<Object> createUtilisateur(@RequestBody UtilisateurDto utilisateur) {
        GetUtilisateurDto user= utilisateurService.save(utilisateur);
        if(user!=null)
            return ResponseEntity.status(200).body(user);
        else

            return ResponseEntity.status(400).body("un erreur au niveau de donnee");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not exist with id :" + id));
        return ResponseEntity.ok(utilisateur);
    }
    //update user
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails){
        Utilisateur utilisateur = utilisateurService.updateUtilisateur(id,utilisateurDetails);
        return ResponseEntity.ok(utilisateur);
    }
    //delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUtilisateur(@PathVariable Long id){
       utilisateurService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{email}")
    public ResponseEntity<?> getUtilisateurByemail(@PathVariable String email) {


        Utilisateur utilisateur = utilisateurService.findByEmail(email);
        if(utilisateur==null){
            return ResponseEntity.badRequest().body("test");
        }else{
            return ResponseEntity.ok(utilisateur);

        }

    }

    @GetMapping("/pointage/{id}")
    public ResponseEntity<?> getPointageByIdUtilisateur(@PathVariable Long id) {
        HashMap<Object,Object> hashMap=utilisateurService.getPointageFromUtilisateur(id);
        if(hashMap!=null){
            return ResponseEntity.status(200).body(hashMap);
        }else{
            return ResponseEntity.status(200).body(new Object());

        }

    }
    @GetMapping("")
    public ResponseEntity<?> getAllUtilisateur() {
        List<GetUtilisateurDto> list=utilisateurService.getAllUtilisateur();
        if(!list.isEmpty()){
            return ResponseEntity.status(200).body(list);
        }else{
            return ResponseEntity.status(200).body(new ArrayList<>());

        }
    }

}
