/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.service;

import com.learn.model.User;

/**
 *
 * @author Administrator
 */
public interface IUserService {
    public User findUserById(int id);
    public void insertUser(User user);
     public void insertRoleAndUser(String roleName,User user);
     public void annotationTransactionalTest(String roleName, User user);
       public void programmingTransactionalTest(String roleName, User user);
     
}
