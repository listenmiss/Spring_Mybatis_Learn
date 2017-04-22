/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.dao;

import com.learn.model.User;

/**
 *
 * @author Administrator
 */
public interface UserMapper {
     User findUserById(int id);
     void insertUser(User user);
}
