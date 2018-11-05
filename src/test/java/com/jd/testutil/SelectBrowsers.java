package com.jd.testutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @class: SelectBrowsers
 * @description:
 * @author: Jindong
 * @create: 2018-10-15 15:56
 **/
public class SelectBrowsers {
    public static  void  SelectBrowsers(String browsername, WebDriver driver,String url){
        switch (browsername) {
            case "chrome":{
                System.setProperty("webdriver.chrome.driver","E:\\driver\\chromedriver.exe");
                driver=new ChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                break;
            }
            case "firefox":{
                System.setProperty("webdriver.chrome.driver","E:\\driver\\chromedriver.exe");
                driver=new ChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                break;
            }
            case "ie":{
                System.setProperty("webdriver.chrome.driver","E:\\driver\\chromedriver.exe");
                driver=new ChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                break;
            }
        }

    }

}
