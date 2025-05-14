package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utilities.JavaScriptUtility.clickJS;

public class BasePage {

    public static WebDriver driver;

    //set driver so other pages can use it
    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    //set a universal find element method for all pages, set to protects so can only be ued here and by child classes
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    //universal set method that uses find method to locate element then pass in the text
    protected void set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator){
        find(locator).click();
    }

    //this combines the standard click method with a Js click method as backup if there is javascript on the page
    protected void clickWithJSBackup(By locator){
        try {
            find(locator).click();
        } catch (ElementClickInterceptedException exc) {
            System.out.println("Caught ElementClickInterceptedException, standard click element method failed, trying click JS");
            exc.printStackTrace();
            clickJS(locator);
        } catch (Exception e){
            System.out.println("Click action failed completley");
            throw e;
        }
    }

    //this is only for debugging/investigation- NOT to be used in actual tests! typically use this before our
    // quit method in the base tear down so we can inspect what the page is doing
    public static void delay(int time){
        try{
            Thread.sleep(time);
        }catch ( InterruptedException exc){
            exc.printStackTrace();
        }
    }

}
