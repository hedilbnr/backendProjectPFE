package com.pointage.teamdevProject.service.impl;

import com.pointage.teamdevProject.dao.RoleRepository;
import com.pointage.teamdevProject.dto.RoleDto;
import com.pointage.teamdevProject.entites.Role;
import com.pointage.teamdevProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

import java.awt.*;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("role not found - " + id));
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, RoleDto roledto) {
        Role role1=null;
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()){
             role1=role.get();
            role1.setRole(roledto.getRole());
            roleRepository.save(role1);
        }
            return role1;
    }


    public boolean deleteRole(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()){
            // .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
            roleRepository.deleteById(id);
            return true;
    }else return false;
    }


}
