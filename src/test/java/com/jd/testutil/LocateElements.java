package com.jd.testutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * @class: LocateElements
 * @description: 将driver.driver.findElement(By.id(element))等元素定位方法重构为一个方法，
 * 方便调用减少代码冗余
 * @author: Jindong
 * @create: 2018-09-20 16:16
 **/
public class LocateElements {

    public static WebElement LocateElemrnt(WebDriver driver , String key) throws IOException {
        WebElement el=null;
        WebDriverWait w=new WebDriverWait(driver,30);
        switch ( ReadProperties.GetTypeByKey(key)){
            case "id":{
                w.until(ExpectedConditions.elementToBeClickable(By.id(ReadProperties.GetValueByKey(key))));
                el=driver.findElement(By.id(ReadProperties.GetValueByKey(key)));
                break;
            }
            case "name":{
                w.until(ExpectedConditions.elementToBeClickable(By.name(ReadProperties.GetValueByKey(key))));
                el=driver.findElement(By.name(ReadProperties.GetValueByKey(key)));
                break;
            }
            case "classname":{
                w.until(ExpectedConditions.elementToBeClickable(By.className(ReadProperties.GetValueByKey(key))));
                el=driver.findElement(By.className(ReadProperties.GetValueByKey(key)));
                break;
            }
            case "tagname":{
                w.until(ExpectedConditions.elementToBeClickable(By.tagName(ReadProperties.GetValueByKey(key))));
                el=driver.findElement(By.tagName(ReadProperties.GetValueByKey(key)));
                break;
            }
            case "linktext":{
                w.until(ExpectedConditions.elementToBeClickable(By.linkText(ReadProperties.GetValueByKey(key))));
                el=driver.findElement(By.linkText(ReadProperties.GetValueByKey(key)));
                break;
            }
            case "partiallinktext":{
                w.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(ReadProperties.GetValueByKey(key))));
                el=driver.findElement(By.partialLinkText(ReadProperties.GetValueByKey(key)));
                break;
            }
            case "xpth":{
                w.until(ExpectedConditions.elementToBeClickable(By.xpath(ReadProperties.GetValueByKey(key))));
                el=driver.findElement(By.xpath(ReadProperties.GetValueByKey(key)));
                break;
            }
            case "cssselector":{
                w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ReadProperties.GetValueByKey(key))));
                el=driver.findElement(By.cssSelector(ReadProperties.GetValueByKey(key)));
                break;
            }
        }
        return el;

    }
}
