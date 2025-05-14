package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;

public class ReportPage extends BasePage {

    public final String PageTitle = "Car-Checking";
    private By make = By.xpath("//td[text()='Make']/following-sibling::td");
    private By model = By.xpath("//td[text()='Model']/following-sibling::td");
    private By yearOfManufacture = By.xpath("//td[text()='Year of manufacture']/following-sibling::td");

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public String getMake(){
     return find(make).getText();
     }

    public String getModel(){
        return find(model).getText();
    }

    public String getYearOfManufacture(){
        return find(yearOfManufacture).getText();
    }
    }
