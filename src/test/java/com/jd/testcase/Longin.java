package com.jd.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

/**
 * @class: Longin
 * @description: 通过第三方（QQ账号）登陆慕课网并验证是否登陆成功。
 * @author: Jindong
 * @create: 2018-09-12 11:57
 **/
public class Longin {




    public WebDriver driver;

    public void InitDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","E:\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.imooc.com/");
        driver.manage().window().maximize();

    }

    public void LoginStript() throws InterruptedException {

       // Thread.sleep(6000);
        //driver.findElement(By.className("js-next-time")).click();
        driver.findElement(By.id("js-signin-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("icon-qq")).click();
        Thread.sleep(2000);
        String currenthandle=driver.getWindowHandle();
        Set<String> handles =driver.getWindowHandles();

        String gohandle=null;
        //for循环判断是不是目标句柄
        for (String handle : handles){
            if(driver.switchTo().window(handle).getTitle().contains("QQ")){
                gohandle=handle;
                break;
            }
        }
        driver.switchTo().window(gohandle);//切换到目标窗口

        /*
        Iterator<String> it = handles.iterator();  	//迭代allhandle里面的句柄
        while(it.hasNext()) {                        	//用it.hasNext()判断时候有下一个窗口,如果有就切换到下一个窗口
            if(driver.switchTo().window(it.next()).getTitle().contains("QQ")){

                break;
            }
        }
        driver.switchTo().window(it.next());
        */

        System.out.println(driver.getTitle());
        driver.switchTo().frame(0);// iframe id=ptlogin_iframe，进入嵌入iframe
        driver.findElement(By.id("switcher_plogin")).click();
        driver.findElement(By.id("u")).sendKeys("1432879007");
        driver.findElement(By.id("p")).sendKeys("hbhgltjind121929");
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(2000);
        driver.switchTo().window(currenthandle);//切换回到原来窗口
        Thread.sleep(2000);

        Actions action = new Actions(driver);//实例化action(鼠标操作对象）
        action.moveToElement(driver.findElement(By.id("header-avator"))).perform();//鼠标移动到目标元素
        if(driver.findElement(By.className("name")).getText().equals("慕粉1462508822")){
            System.out.println("" +
                    "慕课网登录成功");
        }else {
            System.out.println("登录失败");
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Longin longin =new Longin();
        longin.InitDriver();
        longin.LoginStript();


    }


}
