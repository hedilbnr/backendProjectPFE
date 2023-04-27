package com.pointage.teamdevProject.Controller;

import com.pointage.teamdevProject.dto.RoleDto;
import com.pointage.teamdevProject.service.RoleService;
import com.pointage.teamdevProject.entites.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable(value = "id") Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateRole(@PathVariable(value = "id") Long id,  @RequestBody RoleDto roleDto) {
        if(roleService.updateRole(id,roleDto)!=null)
            return ResponseEntity.ok().body("role updated");
        else
            return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable(value = "id") Long id) {
       if(roleService.deleteRole(id)==true)
        return ResponseEntity.ok().body("role deleted");
       else
           return ResponseEntity.status(400).body("id not found");

    }
}