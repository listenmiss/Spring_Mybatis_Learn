/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.dao;

import com.learn.model.Role;

/**
 *
 * @author Administrator
 */
public interface RoleMapper {
     Role findRoleById(int id);
     void insertRole(Role role);
}
