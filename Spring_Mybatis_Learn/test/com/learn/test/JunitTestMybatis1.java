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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class JunitTestMybatis1 {
private ApplicationContext ac;
private IUserService userService;
    public JunitTestMybatis1() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ac = new ClassPathXmlApplicationContext(new String[]{"com/learn/config/spring.xml", "com/learn/config/spring-mybatis.xml"});
         userService = (IUserService) ac.getBean("userService");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test1() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"com/learn/config/spring.xml", "com/learn/config/spring-mybatis.xml"});
//        IUserService userService = (IUserService) ac.getBean("userService");

        User u = userService.findUserById(1);
//        logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
System.out.println(u);
    }
}
