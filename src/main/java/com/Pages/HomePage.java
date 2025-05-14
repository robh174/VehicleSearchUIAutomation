package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends BasePage {
    private By registrationField = By.id("subForm1");
    private By checkNowButton = By.cssSelector("button[type='submit']");
    private By pageHeader = By.cssSelector("a[href='/home']");
    private By errorMessage = By.cssSelector("div[class='alert alert-danger']");
    public final String PageTitle = "Vehicle check - Check Your Car's History Online - Car Checking";

    public boolean isPageDisplayed()
    {
        return find(pageHeader).isDisplayed();
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public void setRegistrationField(String regNumber){
        set (registrationField, regNumber);
    }

    public ReportPage gotoReportPage(){
        scrollToElementJS(registrationField);
        click(checkNowButton);
        return new ReportPage();
    }

    // combined method to login in one sequence, keep other methods for different scenarios
    public ReportPage performRegistrationSearch(String regNumber){
        setRegistrationField(regNumber);
        return gotoReportPage();
    }

    public String getErrorMessage(){
        return find(errorMessage).getText();
    }

}
