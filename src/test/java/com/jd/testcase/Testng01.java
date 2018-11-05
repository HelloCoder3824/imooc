package com.jd.testcase;

import org.testng.annotations.*;

/**
 * @class: Testng01
 * @description:
 * @author: Jindong
 * @create: 2018-10-25 09:50
 **/
public class Testng01 {
    @BeforeMethod
    public void setup()
    {
        System.out.println("begin test");
    }
    @Test
    public void test1()
    {
        System.out.println("at test1");
    }
    @Test
    public void test2()
    {
        System.out.println("at test2");
    }
    @Test
    public void test3()
    {
        System.out.println("at test3");
    }
    @AfterMethod
    public void teardown()
    {
        System.out.println("end test");
    }



}
