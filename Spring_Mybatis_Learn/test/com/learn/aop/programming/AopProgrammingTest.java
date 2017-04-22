/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.aop.programming;

import javax.annotation.Resource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/learn/config/spring.xml", "classpath:com/learn/config/spring-mybatis.xml" })
public class AopProgrammingTest {
    
   @Resource(name="arithmeticCalculator2")
    private ArithmeticCalculator2 arithmeticCalculator2;
    
    public AopProgrammingTest() {
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
     public void aopXmlTest() {
         	
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
//		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		System.out.println(arithmeticCalculator2.getClass().getName());
		
		int result = arithmeticCalculator2.add(1, 2);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator2.div(1000, 10);
		System.out.println("result:" + result);
     }
}
