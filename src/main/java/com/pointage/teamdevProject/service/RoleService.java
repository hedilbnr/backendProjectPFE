package com.pointage.teamdevProject.service;

import com.pointage.teamdevProject.dto.RoleDto;
import com.pointage.teamdevProject.entites.Role;

import java.awt.*;
import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles() ;

    public Role getRoleById(Long id);

    public Role createRole(Role role) ;

    public Role updateRole(Long id, RoleDto roleDto);
    public boolean deleteRole(Long id) ;
    }
