/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.test;

import com.learn.model.User;
import com.learn.service.IUserService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/learn/config/spring.xml", "classpath:com/learn/config/spring-mybatis.xml" })
public class SpringTestMybatis {
    	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
    public SpringTestMybatis() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void findUserByIdTest() {

        User u = userService.findUserById(1);
        System.out.println(u);
     }
     
      @Test
     public void insertUserTest() {
        
         User u = new User();
         u.setAccount("A0006");
         u.setPwd("123");
         u.setUserName("hi");
         u.setRoleId(2);
         
        userService.insertUser(u);
        System.out.println(u);
     }
     /**
      * 测试声明式事务 XML方式,此方法虽然插入role成功，但是插入user失败，所以没有要么一起成功，自动回滚
      */
      @Test
     public void insertRoleAndUser() {
        
         User u = new User();
//         u.setAccount("A0006"); //插入会有非空异常
         u.setPwd("123");
         u.setUserName("hi");
         u.setRoleId(2);
         
        userService.insertRoleAndUser("testrole",u);
        System.out.println(u);
     }
     
     /**
      * 测试声明式事务 注解 方式,此方法虽然插入role成功，但是插入user失败，所以没有要么一起成功，自动回滚
      */
      @Test
     public void annotationTransactionalTest() {
        
         User u = new User();
//         u.setAccount("A0006"); //插入会有非空异常
         u.setPwd("123");
         u.setUserName("hi");
         u.setRoleId(2);
         
        userService.annotationTransactionalTest("testrole",u);
        System.out.println(u);
     }
     /**
      * 编程式事务测试
      */
      @Test
     public void programmingTransactionalTest() {
        
         User u = new User();
//         u.setAccount("A0006"); //插入会有非空异常
         u.setPwd("123");
         u.setUserName("hi");
         u.setRoleId(2);
         
        userService.programmingTransactionalTest("testrole",u);
        System.out.println(u);
     }
     
      
     
}
