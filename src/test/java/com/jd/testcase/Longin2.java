package com.jd.testcase;

import com.jd.testbusiness.LoginService;
import com.jd.testutil.ReadData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * @class: Longin
 * @description: 通过第三方（QQ账号）登陆慕课网并验证是否登陆成功。
 * @author: Jindong
 * @create: 2018-09-12 11:57
 **/
public class Longin2 {




    public WebDriver driver;

    /**
     *
     */
    @Parameters({"url"})
    @BeforeMethod
    public void BeforeLogin(String url){

        System.setProperty("webdriver.chrome.driver","E:\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @DataProvider(name="imooc")
    public Object[][] GetAccount() throws Exception {
        Object[][] objects=ReadData.ReadData();
        return objects;
    }


    @Test(dataProvider ="imooc")
    //public void LoginStript(String content ) throws Exception {
    public void LoginStript(String username ,String password ) throws Exception {
        System.out.println(username+","+password);
        LoginService.login(driver,username,password);


    }

/*
@Test
  public void Test01(){
    System.out.println("test01");
}

*/
    @AfterMethod
    public void AfterLogin(){
        driver.close();
    }

}
