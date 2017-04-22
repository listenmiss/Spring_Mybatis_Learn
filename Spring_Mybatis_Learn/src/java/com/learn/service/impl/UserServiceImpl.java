/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.service.impl;

import com.learn.dao.RoleMapper;
import com.learn.dao.UserMapper;
import com.learn.model.Role;
import com.learn.model.User;
import org.springframework.stereotype.Service;
import com.learn.service.IUserService;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author Administrator
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

//    private UserMapper userMapper;
//
//    public UserMapper getUserMapper() {
//        return userMapper;
//    }
//
//    @Autowired
//    public void setUserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
        System.out.println("save user done!");
    }

    /**
     * 声明式事务一: XML方式,需要加入<tx:advice>和<aop:config>，见配置文件spring-mybatis.xml
     *
     * @param roleName
     * @param user
     */
    @Override
    public void insertRoleAndUser(String roleName, User user) {
        Role r = new Role();
        r.setRoleName(roleName);

        roleMapper.insertRole(r);
        int roleId = r.getRoleId();
        System.out.println("role id is:" + roleId);
        user.setRoleId(roleId);
        userMapper.insertUser(user);
        System.out.println("save user done!");

    }

    /**
     * 声明式事务二: 注解方式方式,需要在配置文件spring-mybatis.xml加入
     *
     * @param roleName
     * @param user
     */
    //添加事务注解,此方法不包含在声明式XML< tx:attributes >拦截的方法中;
   @Transactional()
    @Override
    public void annotationTransactionalTest(String roleName, User user) {
        Role r = new Role();
        r.setRoleName(roleName);

        roleMapper.insertRole(r);
        int roleId = r.getRoleId();
        System.out.println("role id is:" + roleId);
        user.setRoleId(roleId);
        userMapper.insertUser(user);
        System.out.println("save user done!");

    }

    @Resource
    private DataSourceTransactionManager transactionManager;

    /**
     * 编程式事务
     *
     * @param roleName
     * @param user
     */
    @Override
    public void programmingTransactionalTest(String roleName, User user) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Role r = new Role();
            r.setRoleName(roleName);

            roleMapper.insertRole(r);
            int roleId = r.getRoleId();
            System.out.println("role id is:" + roleId);
            user.setRoleId(roleId);
            userMapper.insertUser(user);
           
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        transactionManager.commit(status);
         System.out.println("save user done!");
    }

}
