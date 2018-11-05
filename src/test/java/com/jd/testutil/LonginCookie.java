package com.jd.testutil;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * @class: LonginCookie
 * @description:
 * @author: Jindong
 * @create: 2018-10-16 16:32
 **/
public class LonginCookie {

    public  static Set<Cookie> GetCookies(WebDriver driver){
        Set<Cookie> cookies = driver.manage().getCookies();
        return  cookies;
    }

    public  static void  SetCookies(WebDriver driver) {
        Set<Cookie> cookies = LonginCookie.GetCookies(driver);
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "\t" + cookie.getValue());

            new Cookie("key", "value");
            //添加cookie操作
            driver.manage().addCookie(cookie);

            driver.manage().window().maximize();
            //下面是见证奇迹的时候了
            driver.navigate().refresh();
        }
    }
}
