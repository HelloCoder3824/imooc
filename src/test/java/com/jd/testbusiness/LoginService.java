package com.jd.testbusiness;

import com.jd.testutil.LocateElements;
import com.jd.testutil.LonginCookie;
import com.jd.testutil.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @class: LoginService
 * @description:
 * @author: Jindong
 * @create: 2018-09-25 17:25
 **/
public class LoginService {
    //public static void login(WebDriver driver , String content) throws IOException, InterruptedException {
    public static void login(WebDriver driver,String username ,String password ) throws IOException, InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            LocateElements.LocateElemrnt( driver ,"cancel").click();
        }catch (Exception e){
            System.out.println("找不到'cancel'");
        }

        LocateElements.LocateElemrnt( driver ,"login").click();
        Thread.sleep(2000);
        LocateElements.LocateElemrnt( driver ,"qqlogin").click();
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
        LocateElements.LocateElemrnt( driver ,"qqacountlogin").click();
        LocateElements.LocateElemrnt( driver ,"username" ).sendKeys(username);
        LocateElements.LocateElemrnt( driver ,"password" ).sendKeys(password);
        LocateElements.LocateElemrnt( driver ,"loginbutton" ).click();
        Thread.sleep(2000);
        driver.switchTo().window(currenthandle);//切换回到原来窗口
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 20);
       // String locatetype1=ReadProperties.GetTypeByKey("floating");
        //String locatevalue1=ReadProperties.GetValueByKey("floating");
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.locatetype1(locatevalue1)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-avator")));

        Actions action = new Actions(driver);//实例化action(鼠标操作对象）
        action.moveToElement(LocateElements.LocateElemrnt( driver ,"floating")).perform();//鼠标移动到目标元素
        if(LocateElements.LocateElemrnt( driver ,"imoocusername" ).getText().equals("慕粉1462508822")){
            System.out.println("登录成功");
            LonginCookie.GetCookies(driver);
        }else {
            System.out.println("登录失败");
        }




    }

}
